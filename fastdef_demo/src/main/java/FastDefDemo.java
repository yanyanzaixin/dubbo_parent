import org.csource.fastdfs.*;

import java.io.File;

public class FastDefDemo {
    public static void main(String[] args) throws Exception {
        ClientGlobal.init("D:\\develop\\Maven_Project\\dubbo_parent\\fastdef_demo\\src\\fdfs_client.conf");
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer=trackerClient.getConnection();
        StorageServer storageServer=null;
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
        File file=new File("E:\\img\\cs10009.jpg");
       // File files[]=dir.listFiles();
//        for (File file : files) {
//            String extName=file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1);
//            String[] uploadFile = storageClient.upload_file(file.getAbsolutePath(), extName, null);
//            for(String upFile:uploadFile){
//                System.out.println(upFile);
//            }
//        }

    String extName=file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1);
    String[] uploadFile = storageClient.upload_file(file.getAbsolutePath(), extName, null);
        for (String s : uploadFile) {
                System.out.println(s);
             }

    }
 }
