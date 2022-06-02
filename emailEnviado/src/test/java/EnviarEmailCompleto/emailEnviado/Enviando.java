package EnviarEmailCompleto.emailEnviado;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.SharedFileInputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Enviando {
	
 private FileInputStream simuladorpdf()throws Exception{
		Document documento =new Document();
		File file=new File("anexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(documento,new FileOutputStream(file));
		documento.open();
		documento.add(new Paragraph("Conteudo do pdf anexo"));
		documento.close();
		return new FileInputStream(file);
		
	}

	private String userName ="ThiagoTesteEmail168@gmail.com";
	private String senha="25059090";
	
	
	private String listaDestinatarios ="tmachado807@gmail.com,ThiagoTesteEmail168@gmail.com";
	private String nomeRemetente =userName;
	private String assuntoEmail= "Chegou Email enviado com java";
	private String textEmail="Olá programador, vc acaba de receber um e-mail enviado com java";


		
		@org.junit.Test    // com junit serve para testar unitario metodos 
		public void Email (){ // metodo  criado para teste
			try {
			/*Olhar as configuraçoes smtp do seu email*/
			Properties properties =new Properties();
			
			
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");//autorização
			properties.put("mail.smtp.starttls", "true");//autentificação
			properties.put("mail.smtp.host", "smtp.gmail.com");//servidor gmail google
			
			properties.put("mail.smtp.port", "465"); //porta do google
			properties.put("mail.smtp.socketFactory.port", "465"); // especifica a posta conectada pelo socket
			properties.put("mail.smtp.socketFactory.Class", "java.net.ssl.SSLSocketFactory");//class socket  de conecção SMTP
			
			Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
			
			
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(userName, senha);
			}
			
			});
			
			System.err.println("Enviado");
			
			Address[] toUser = InternetAddress.parse(listaDestinatarios);//lista desejada para quem eu quero mandar
					
			Message mensagem =new MimeMessage(session);//aqui para escrever o assunto e o texto do email
			mensagem.setFrom(new InternetAddress(nomeRemetente));// quem esta enviando
			mensagem.setRecipients(Message.RecipientType.TO, toUser);//aqui irá inserir
			mensagem.setSubject(assuntoEmail);
			mensagem.setText(textEmail);
		
			
			
		Transport.send(mensagem);
		
		
		/*Envio de email*/
			
		
		
		
		
		
		
		
		
	 Thread.sleep(5000);
		
	 

		
			
			}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
			
		}



		private void FileInputStream() {
			// TODO Auto-generated method stub
			
		}


		
		
	}


