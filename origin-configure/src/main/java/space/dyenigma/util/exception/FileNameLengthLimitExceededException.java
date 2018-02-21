package space.dyenigma.util.exception;

import org.apache.commons.fileupload.FileUploadException;

/**
 * origin/space.dyenigma.util.exception
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2016/3/16
 */
public class FileNameLengthLimitExceededException extends FileUploadException {

    private int length;
    private int maxLength;
    private String filename;

    public FileNameLengthLimitExceededException(String filename, int length, int maxLength) {
        super("file name : [" + filename + "], length : [" + length + "], max length : [" + maxLength + "]");
        this.length = length;
        this.maxLength = maxLength;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public int getLength() {
        return length;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
