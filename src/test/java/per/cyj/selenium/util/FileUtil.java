package per.cyj.selenium.util;

import java.io.File;
import java.io.IOException;

/**
 * @author ucs_chenyongjun
 * @apiNote FilUitl类用于创建目录和文件，此例子中只使用此类的创建目录方法，
 * 创建文件的方法仅供大家参考，将来用于跟进测试需要创建指定的数据文件
 * @since 2019-08-13
 */
public class FileUtil {

    /**
     * 创建目标文件
     *
     * @param destFileName 目标文件名称
     * @return flag
     */
    public static boolean createFile(String destFileName) {
        boolean flag = false;
        File file = new File(destFileName);
        if (file.exists()) {
            flag = false;
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
        }
        if (destFileName.endsWith(File.separator)) {
            flag = false;
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
        }
        // 判断目标文件所在目录是否存在
        if (!file.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在的目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs()) {
                flag = false;
                System.out.println("创建目标文件所在的目录失败！");
            }
        }
        // 创建目标文件
        try {
            if (file.createNewFile()) {
                flag = true;
                System.out.println("创建单个文件" + destFileName + "成功！");
            } else {
                flag = false;
                System.out.println("创建单个文件" + destFileName + "失败！");
            }
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
        }
        return flag;
    }

    /**
     * 创建目标目录
     *
     * @param destDirName 目标文件名称
     * @return flag
     */
    public static boolean createDir(String destDirName) {
        boolean flag = false;
        File dir = new File(destDirName);
        if (dir.exists()) {
            flag = false;
            System.out.println("创建目录" + destDirName + "失败，目标目录已存在！");
        }
        // 创建目录
        if (dir.mkdirs()) {
            flag = true;
            System.out.println("创建目录" + destDirName + "成功！");
        } else {
            flag = false;
            System.out.print("创建目录" + destDirName + "失败！");
        }
        return flag;
    }
}
