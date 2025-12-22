package rave.code.utility.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.io.File;
import java.util.Properties;


public class JavaMailer implements Mail {

    public static final String MAIL_HOST_PROPERTY = "mail.smtp.host";
    public static final String PROTOCOL_POP3 = "pop3s";
    public static final String PROTOCOL_IMAP = "imaps";
    public static final int POP3_ENCRYPTED_PORT = 995;
    public static final int IMAP_ENCRYPTED_PORT = 993;

    private String userName;
    private String password;
    private Session session;

    private int getPort(String protocol) {
        return 25;
    }

    public void connect(String host, String port, final String userName,
                        final String password) {
        this.userName = userName;
        this.password = password;
        Properties props = new Properties();
        props.put(MAIL_HOST_PROPERTY, host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        this.session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

    }

    public Session getSession() {
        return this.session;
    }

    public void sendMail(String from, String[] tos, String[] ccs,
                         String[] bccs, String[] attachments, String subject, String message)
            throws MessagingException {
        Message mimeMessage = new MimeMessage(this.getSession());
        mimeMessage.setFrom(new InternetAddress(from));

        InternetAddress[] toAddresses = new InternetAddress[tos.length];
        for (int i = 0; i < tos.length; i++) {
            toAddresses[i] = new InternetAddress(tos[i]);
        }
        mimeMessage.setRecipients(Message.RecipientType.TO, toAddresses);

        InternetAddress[] ccAddresses = new InternetAddress[ccs.length];
        for (int i = 0; i < ccs.length; i++) {
            ccAddresses[i] = new InternetAddress(ccs[i]);
        }
        mimeMessage.setRecipients(Message.RecipientType.CC, ccAddresses);

        InternetAddress[] bccAddresses = new InternetAddress[bccs.length];
        for (int i = 0; i < bccs.length; i++) {
            bccAddresses[i] = new InternetAddress(bccs[i]);
        }
        mimeMessage.setRecipients(Message.RecipientType.BCC, bccAddresses);

        mimeMessage.setSubject(subject);
        BodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
        mimeBodyPart.setContent(message, "text/html; charset=utf-8");
        Multipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);

        for (String attachment : attachments) {
            File file = new File(attachment);
            mimeBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            mimeBodyPart.setDataHandler(new DataHandler(source));
            mimeBodyPart.setFileName(file.getName());
            mimeMultipart.addBodyPart(mimeBodyPart);
        }

        mimeMessage.setContent(mimeMultipart);
        mimeMessage.saveChanges();
        Transport.send(mimeMessage);
    }

    public void sendMail(String from, String to, String subject, String message)
            throws MessagingException {
        String[] tos = {to};
        this.sendMail(from, tos, new String[0], new String[0], new String[0],
                subject, message);
    }

    public void sendMail(String from, String to, String[] ccs, String subject,
                         String message) throws MessagingException {
        String[] tos = {to};
        this.sendMail(from, tos, ccs, new String[0], new String[0], subject,
                message);
    }

    public void sendMail(String from, String to, String[] ccs, String[] bccs,
                         String subject, String message) throws MessagingException {
        String[] tos = {to};
        this.sendMail(from, tos, ccs, bccs, new String[0], subject, message);
    }

    public void sendMail(String from, String to, String[] ccs, String[] bccs,
                         String[] attachments, String subject, String message)
            throws MessagingException {
        String[] tos = {to};
        this.sendMail(from, tos, ccs, bccs, attachments, subject, message);
    }

    public Message[] checkFolder(String folderName, String protocol)
            throws MessagingException {
        Store store = this.getSession().getStore(protocol);
        store.connect(this.getSession().getProperty(MAIL_HOST_PROPERTY),
                this.userName, this.password);
        Folder folder = store.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        Message[] messages = folder.getMessages();
        folder.close(false);
        store.close();
        return messages;
    }

    public Message[] getUnReadMessages(String folderName, String protocol,
                                       boolean encrypted) throws MessagingException {
        int port = this.getPort(protocol);
        Store store = this.getSession().getStore(protocol);
        store.connect(this.getSession().getProperty(MAIL_HOST_PROPERTY), port,
                this.userName, this.password);
        Folder folder = store.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        Flags flags = new Flags(Flags.Flag.SEEN);
        FlagTerm flafTerm = new FlagTerm(flags, false);
        Message[] messages = folder.search(flafTerm);
        folder.close(false);
        store.close();
        return messages;
    }

    public Message[] getSentMessages(String folderName, String protocol,
                                     boolean encrypted) throws MessagingException {
        int port = this.getPort(protocol);
        Store store = this.getSession().getStore(protocol);
        store.connect(this.getSession().getProperty(MAIL_HOST_PROPERTY), port,
                this.userName, this.password);
        Folder folder = store.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        Flags flags = new Flags(Flags.Flag.ANSWERED);
        FlagTerm flagTerm = new FlagTerm(flags, true);
        Message[] messages = folder.search(flagTerm);
        folder.close(false);
        store.close();
        return messages;
    }

    public Message[] getDrafts(String folderName, String protocol,
                               boolean encrypted) throws MessagingException {
        int port = this.getPort(protocol);
        Store store = this.getSession().getStore(protocol);
        store.connect(this.getSession().getProperty(MAIL_HOST_PROPERTY), port,
                this.userName, this.password);
        Folder folder = store.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        Flags flags = new Flags(Flags.Flag.DRAFT);
        FlagTerm flagTerm = new FlagTerm(flags, true);
        Message[] messages = folder.search(flagTerm);
        folder.close(false);
        store.close();
        return messages;
    }
}