package test5;
import java.io.*;
public class FileHandle {
	
		  private static boolean isExitFile(String fileName){
				File file=new File(fileName);
				if(file.exists()){
					if(file.isFile()){
						return true;
					}
				}
				return false;
			}
			
			public static BufferedInputStream readFile(String fileName){
				BufferedInputStream bis=null;
				try {
					if(isExitFile(fileName)){
						bis = new BufferedInputStream(new FileInputStream(fileName));

					}else{
						System.out.println("�ļ������ڣ�������ʧ��");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				return bis;
			}

			public static void writeFile(String content,String fileName){
				BufferedWriter bw=null;
				try {
					bw=new BufferedWriter(new FileWriter(fileName));
					bw.write(content);
//					ˢ�»���
					bw.flush();
					System.out.println("�ļ�д��ɹ�");
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						if(bw!=null){
							bw.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
//			ɾ��ָ���ļ�
			public static void deleteFile(String fileName){
				if(isExitFile(fileName)){
					File file=new File(fileName);
					file.delete();
					System.out.println("ɾ���ɹ�");
				}else{
					System.out.println("�ļ������ڣ�ɾ��ʧ��");
				}
			}
//			���ָ��Ŀ¼�µ��ض����͵��ļ�
			public static void files(String fileName,String type){
				
				File file=new File(fileName);
//				�ж��ļ���������Ŀ¼
				if(file.exists()){
					if(file.isDirectory()){
//						�õ�Ŀ¼�µ������ļ�
						File[] files=file.listFiles();
//						���������ļ������������type�������ļ�
						for(File i:files){
							if(i.getName().endsWith(type)){
								System.out.println(i.getName());
							}
						}
					}
				}else{
					System.out.println("�ļ������ڻ��߲���Ŀ¼·��");
				}
			}
//			���������ļ���д��һ���ļ�
			public static void connectFile(String fileName1,String fileName2,String endpath){
				if(isExitFile(fileName1)&&isExitFile(fileName2)){
					BufferedInputStream b1=null;
					BufferedInputStream b2=null;	//������
					SequenceInputStream ss=null;	//�ϲ���
					BufferedOutputStream bos=null;	//�����
					try {
						b1=new BufferedInputStream(new FileInputStream(fileName1));
						b2=new BufferedInputStream(new FileInputStream(fileName2));
						ss=new SequenceInputStream(b1, b2);	//�ϲ�������
						bos=new BufferedOutputStream(new FileOutputStream(endpath));
						//�����д���ļ�
						byte[] bytes=new byte[1024];
						int n=0;
						while((n=ss.read(bytes))!=-1){
							bos.write(bytes, 0, n);
							bos.flush();
						}
						System.out.println("�����ɹ�");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						if(b1!=null){
							try {
								b1.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if(b2!=null){
							try {
								b2.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if(ss!=null){
							try {
								ss.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if(bos!=null){
							try {
								bos.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					
				}
				else{
					System.out.println("�ļ�1�����ļ�2������");
				}
				
			}
		}
