package test5;
import java.io.*;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("--------�ļ��༭��---------");
		System.out.println("1.���ļ�");
		System.out.println("2.д�ļ�");
		System.out.println("3.ɾ���ļ�");
		System.out.println("4.�ļ�Ŀ¼��ָ�������ļ�");
		System.out.println("5.���������ļ��ļ�");
		int step=in.nextInt();
		if(step==1){
			BufferedInputStream bis=FileHandle.readFile("D:\\aaa.txt");
			if(bis==null){
				System.out.println("��������ȡʧ��");
			}else{
				try {
					byte[] bytes=new byte[1024];
					@SuppressWarnings("unused")
					int n=0;
					while((n=bis.read(bytes))!=-1){
						System.out.println(bytes);//�����֤������ȷ��
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
			System.out.println("�������������ݣ�");
			String s = in.next();
//			System.out.println(s);
			System.out.println("����������·����");
			String path=in.next();
			FileHandle.writeFile(s, path);
		}else if(step==3){
			System.out.println("������ɾ�����ļ�Ŀ¼");
			String fileName = in.next();
			FileHandle.deleteFile(fileName);
		}else if(step==4){
			System.out.println("�������ļ�Ŀ¼��ָ�������ļ�");
			String fileName = in.next();
			System.out.println("������ָ�������ļ�");
			String type = in.next();
			FileHandle.files(fileName, type);
		}else if(step==5){
			System.out.println("�������ļ�1����Ŀ¼");
			String fileName1 = in.next();
			System.out.println("�������ļ�2����Ŀ¼");
			String fileName2 = in.next();
			System.out.println("������ת����ļ�Ŀ¼");
			String endpath = in.next();
			FileHandle.connectFile(fileName1, fileName2, endpath);
		}
	}
}
