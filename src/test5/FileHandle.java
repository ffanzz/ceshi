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
						System.out.println("文件不存在，创建流失败");
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
//					刷新缓存
					bw.flush();
					System.out.println("文件写入成功");
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
//			删除指定文件
			public static void deleteFile(String fileName){
				if(isExitFile(fileName)){
					File file=new File(fileName);
					file.delete();
					System.out.println("删除成功");
				}else{
					System.out.println("文件不存在，删除失败");
				}
			}
//			获得指定目录下的特定类型的文件
			public static void files(String fileName,String type){
				
				File file=new File(fileName);
//				判断文件存在且是目录
				if(file.exists()){
					if(file.isDirectory()){
//						得到目录下的所有文件
						File[] files=file.listFiles();
//						遍历所有文件，输出名字以type结束的文件
						for(File i:files){
							if(i.getName().endsWith(type)){
								System.out.println(i.getName());
							}
						}
					}
				}else{
					System.out.println("文件不存在或者不是目录路径");
				}
			}
//			连接两个文件并写入一个文件
			public static void connectFile(String fileName1,String fileName2,String endpath){
				if(isExitFile(fileName1)&&isExitFile(fileName2)){
					BufferedInputStream b1=null;
					BufferedInputStream b2=null;	//输入流
					SequenceInputStream ss=null;	//合并流
					BufferedOutputStream bos=null;	//输出流
					try {
						b1=new BufferedInputStream(new FileInputStream(fileName1));
						b2=new BufferedInputStream(new FileInputStream(fileName2));
						ss=new SequenceInputStream(b1, b2);	//合并两个流
						bos=new BufferedOutputStream(new FileOutputStream(endpath));
						//输出流写入文件
						byte[] bytes=new byte[1024];
						int n=0;
						while((n=ss.read(bytes))!=-1){
							bos.write(bytes, 0, n);
							bos.flush();
						}
						System.out.println("操作成功");
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
					System.out.println("文件1或者文件2不存在");
				}
				
			}
		}
