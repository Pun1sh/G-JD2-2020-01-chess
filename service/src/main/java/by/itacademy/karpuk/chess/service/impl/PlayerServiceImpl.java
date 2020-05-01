package by.itacademy.karpuk.chess.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IPlayerDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.service.IPlayerService;

@Service
public class PlayerServiceImpl implements IPlayerService {
	@Autowired
	private IPlayerDao dao;

	@Override
	public IPlayer get(Integer id) {
		final IPlayer entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IPlayer> getAll() {
		final List<IPlayer> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IPlayer entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
			sendMail(entity.toString(), "new player created");
		} else {
			dao.update(entity);
		}
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();

	}

	@Override
	public IPlayer createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IPlayer> find(PlayerFilter filter) {
		return dao.find(filter);
	}

	@Override
	public IPlayer getFullInfo(final Integer id) {
		return dao.getFullInfo(id);
	}

	@Override
	public IPlayer getPlayerByNickname(String nickname) {
		return dao.getPlayerByNickname(nickname);
	}

	private void sendMail(String body, String subject) {

		final String username = "thepunisherofnoobs@gmail.com";
		final String password = "zvdxhvlxvfgxzxpf";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dmitri.zhyvushko@gmail.com"));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
