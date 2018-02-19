package space.dyenigma.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.common.SpecificationUtil;
import space.dyenigma.dao.ShiroUserDao;
import space.dyenigma.service.ShiroRoleService;
import space.dyenigma.service.ShiroUserService;
import space.dyenigma.shiro.ShiroRole;
import space.dyenigma.shiro.ShiroUser;
import space.dyenigma.util.Constants;
import space.dyenigma.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:41
 */
@Service
@Slf4j
public class ShiroUserServiceImpl extends EntityServiceImpl<ShiroUser, Long, ShiroUserDao> implements ShiroUserService {

    private final Logger logger = LoggerFactory.getLogger(ShiroUserServiceImpl.class);

    @Autowired
    ShiroRoleService shiroRoleService;

    /**
     * @param shiroUser
     * @return space.dyenigma.util.ResponseJson
     * @Description : 管理员修改用户基本信息
     * @author dingdongliang
     * @date 2018/2/15 8:39
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseJson editUser(ShiroUser shiroUser) {

        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");

        logger.info(shiroUser.toString());

        ShiroUser shiroUserTemp = this.findByUsernameForUpdate(shiroUser.getUsername());

        this.save(shiroUserTemp);
        return responseJson;

    }

    /**
     * @param shiroUser
     * @return space.dyenigma.util.ResponseJson
     * @Description : 管理员添加用户
     * @author dingdongliang
     * @date 2018/2/15 8:39
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseJson addUser(ShiroUser shiroUser) {

        ResponseJson responseJson = new ResponseJson();
        ShiroUser shiroUserTemp = null;
        try {

            shiroUserTemp = this.findByUsername(shiroUser.getUsername());
            if (shiroUserTemp != null) {

                responseJson.setMsg("usernameExist");
                return responseJson;
            }

            String password = new Md5Hash(Constants.initPassword, "www", 1024).toBase64();

            shiroUser.setPassword(password);
            shiroUser.setStatus(Constants.userStatus_0);
            shiroUser.setCreateTime(new Date());

            this.save(shiroUser);

        } catch (Exception e) {
            e.printStackTrace();
            responseJson.setMsg("false");
            return responseJson;
        }

        responseJson.setMsg("success");
        return responseJson;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseJson checkNameOrEmallExist(ShiroUser shiroUser) {

        ResponseJson responseJson = new ResponseJson();
        logger.info(shiroUser.toString());
        ShiroRole shiroRoleTemp = null;
        ShiroUser shiroUserTemp = null;
        try {
            shiroUserTemp = this.findByUsername(shiroUser.getUsername());
            if (shiroUserTemp != null) {
                responseJson.setMsg("false");
                return responseJson;
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseJson.setMsg("false");
            return responseJson;
        }

        responseJson.setMsg("true");
        return responseJson;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseJson del(String ids) throws Exception {
        ResponseJson responseJson = new ResponseJson();

        ShiroUser user;
        String idsArr[] = ids.split(",");

        for (int i = 0; i < idsArr.length; i++) {
            user = entityDao.findByUsername(idsArr[i]);
            if (user.getUsername().equals("admin")) {
                responseJson.setMsg("admin");
                throw new Exception("admin");
            }
            entityDao.delete(user);
        }

        responseJson.setMsg("success");
        return responseJson;
    }

    public ResponseJson editUserRole(String username, String roles) {
        ResponseJson responseJson = new ResponseJson();
        ShiroUser shiroUserTemp = this.findByUsernameForUpdate(username);
        String rolesArr[] = roles.split(",");
        List<ShiroRole> roleList = new ArrayList<ShiroRole>();
        for (int i = 0; i < rolesArr.length; i++) {
            ShiroRole shiroRoleTemp = shiroRoleService.findByRoleName(rolesArr[i]);
            roleList.add(shiroRoleTemp);
        }
        shiroUserTemp.setRoleList(roleList);
        this.save(shiroUserTemp);
        responseJson.setMsg("success");
        responseJson.setSuccess(true);

        return responseJson;
    }

    @Override
    public ShiroUser findByUsernameForUpdate(String username) {
        return entityDao.findByUsernameForUpdate(username);
    }

    @Override
    public ShiroUser findByUsername(String userName) {
        return entityDao.findByUsername(userName);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseJson audit(String userNameStr, String status) throws Exception {

        ResponseJson responseJson = new ResponseJson();

        responseJson.setMsg("success");
        String userNameArray[] = userNameStr.split(",");
        int length = userNameArray.length;
        logger.info("length====" + length);

        for (int i = 0; i < length; i++) {
            String username = userNameArray[i];
            logger.info("username====" + username);
            logger.info("status====" + status);
            ShiroUser shiroUser = entityDao.findByUsername(username);

            if (shiroUser.getRoleList() == null || shiroUser.getRoleList().size() == 0) {//审核之前必须先给用户赋角色
                throw new Exception("roleNotExist");
            } else {
                shiroUser.setStatus(status);
                entityDao.save(shiroUser);
                responseJson.setMsg("success");
            }

        }
        return responseJson;
    }

    @Override
    public List<ShiroUser> findList() {

        List<ShiroUser> list = (List) entityDao.findAll();
        return list;
    }

    @Override
    public PaginationResult<ShiroUser> findAllByPage(Pagination<ShiroUser> pagination) {

        SpecificationUtil<ShiroUser> specificationUtil = new SpecificationUtil<ShiroUser>();

        Map<String, Object> searchParams = new HashMap<String, Object>();

        ShiroUser ShiroUser = new ShiroUser();

        ShiroUser = pagination.dataTable2Entry(ShiroUser, pagination);//封装前段调用的数据。

        List<String> properties = new ArrayList<String>();
        properties.add("id");
        Sort sort = new Sort(Direction.DESC, properties);

        sort = pagination.dataTableOrder(pagination, sort, properties);

        String extra_search = pagination.getExtra_search();//查询条件
        logger.info("extra_search=" + extra_search);

        String paramArray[] = extra_search.split("&");
        Map map = new HashMap();
        for (int i = 0; i < paramArray.length; i++) {
            String name = paramArray[i].split("=")[0];
            if (paramArray[i].split("=").length == 2) {
                String value = paramArray[i].split("=")[1];
                map.put(name, value);
            } else {
                map.put(name, "");
            }
        }

        if (!map.get("username").equals("")) {
            searchParams.put("LIKES_username", map.get("username"));
        }

        if (!map.get("status").equals("")) {
            searchParams.put("EQS_status", map.get("status"));
        }

        logger.info("searchParams.toString()==" + searchParams.toString());

        Specification<ShiroUser> specification = specificationUtil.buildSpecification(searchParams, "and");

        int page = pagination.getStart() / pagination.getPageSize();
        PageRequest PageRequest = new PageRequest(page, pagination.getPageSize(), sort);

        Page<ShiroUser> list = entityDao.findAll(specification, PageRequest);

        PaginationResult<ShiroUser> pa = new PaginationResult();

        pa.setData(list.getContent());
        pa.setRecordsFiltered(list.getTotalElements());
        pa.setRecordsTotal(list.getTotalElements());
        pa.setDraw(new Integer(pagination.getDraw()));
        return pa;
    }

    @Override
    @Autowired
    public void setEntityDao(ShiroUserDao entityDao) {
        this.entityDao = entityDao;
    }
}