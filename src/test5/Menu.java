package test5;
import java.io.*;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("--------文件编辑器---------");
		System.out.println("1.读文件");
		System.out.println("2.写文件");
		System.out.println("3.删除文件");
		System.out.println("4.文件目录和指定类型文件");
		System.out.println("5.连接两个文件文件");
		int step=in.nextInt();
		if(step==1){
			BufferedInputStream bis=FileHandle.readFile("D:\\aaa.txt");
			if(bis==null){
				System.out.println("输入流获取失败");
			}else{
				try {
					byte[] bytes=new byte[1024];
					@SuppressWarnings("unused")
					int n=0;
					while((n=bis.read(bytes))!=-1){
						System.out.println(bytes);//输出验证流的正确性
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(bis!=null)
							bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
		}else if(step==2){
			System.out.println("请输入存入的内容：");
			String s = in.next();
//			System.out.println(s);
			System.out.println("请输入存入的路径：");
			String path=in.next();
			FileHandle.writeFile(s, path);
		}else if(step==3){
			System.out.println("请输入删除的文件目录");
			String fileName = in.next();
			FileHandle.deleteFile(fileName);
		}else if(step==4){
			System.out.println("请输入文件目录和指定类型文件");
			String fileName = in.next();
			System.out.println("请输入指定类型文件");
			String type = in.next();
			FileHandle.files(fileName, type);
		}else if(step==5){
			System.out.println("请输入文件1所在目录");
			String fileName1 = in.next();
			System.out.println("请输入文件2所在目录");
			String fileName2 = in.next();
			System.out.println("请输入转存的文件目录");
			String endpath = in.next();
			FileHandle.connectFile(fileName1, fileName2, endpath);
		}
	}
}
