package EnviarEmailCompleto.emailEnviado;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Enviando {

	
	

		

		private String userName ="ThiagoTesteEmail168@gmail.com";
		
		private String senha="25059090";
		
		
		@org.junit.Test    // com junit serve para testar unitario metodos 
		public void Email(){ // metodo  criado para teste
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
			
			System.err.println(senha);
			
			Address[] toUser = InternetAddress.parse("tmachado807@gmail.com,ThiagoTesteEmail168@gmail.com");
					
			Message mensagem =new MimeMessage(session);
			mensagem.setFrom(new InternetAddress(userName));// quem esta enviando
			mensagem.setRecipients(Message.RecipientType.TO, toUser);
			mensagem.setSubject("Chegou Email enviado com java");
			mensagem.setText("Olá programador, vc acaba de receber um e-mail enviado com java ");
			
		Transport.send(mensagem);
		
			
			}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
	}


