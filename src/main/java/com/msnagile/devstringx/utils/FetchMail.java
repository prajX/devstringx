package com.msnagile.devstringx.utils;

import jakarta.mail.*;
import jakarta.mail.search.*;
import java.util.Properties;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchMail {
    String host;
    String username;
    String password;
    Properties props = new Properties();

     public FetchMail(String host,String username,String password){
        this.host=host;
        this.username=username;
        this.password=password;
        props.put("mail.store.protocol","imaps");
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
        props.put("mail.imap.ssl.enable", "true");
    }
    

    public String fetch(){
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, username, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            String sender = "support@devstringx.com";
            String subject = "Please confirm your account"; 
            String link=null;

            SearchTerm senderSearch = new FromStringTerm(sender); 
            SearchTerm subjectSearch = new SubjectTerm(subject);  
            SearchTerm combinedSearch = new AndTerm(senderSearch, subjectSearch);
    
            Message[] messages = inbox.search(combinedSearch);
            System.out.println("Number of messages found: " + messages.length);


                if (messages.length > 0) {
                    Message message = messages[0];
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Date: " + message.getSentDate());

                    if (message.isMimeType("text/html")) {
                        String htmlContent = (String) message.getContent();
                        Document doc = Jsoup.parse(htmlContent);
                        Element firstLink = doc.selectFirst("a[href]");
                        if (firstLink != null) {
                            link = firstLink.attr("href");
                            String linkText = firstLink.text();
                            System.out.println("First Link: " + link);
                            System.out.println("Link Text: " + linkText);
                        }
                }

            }
    
            inbox.close(false);
            store.close();
            return link;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }

}
