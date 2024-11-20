package com.example.demo.service;

import com.example.demo.model.WebCard;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * @author Bruno Ramirez
 */
@Service
public class BuilderWebCardHtmlService {

    public String buildHtml(String hashedObject) throws Exception {
        try {
            String decodedJson = new String(Base64.getDecoder().decode(hashedObject));

            ObjectMapper objectMapper = new ObjectMapper();
            WebCard webCard = objectMapper.readValue(decodedJson, WebCard.class);

            return "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "    <head>\n" +
                    "        <meta property=\"og:title\" content=\"" + webCard.getTitle() + "\" />\n" +
                    "        <meta property=\"og:type\" content=\"website\" />\n" +
                    "        <meta property=\"og:image\" content=\"https://i.ibb.co/Jy4nzHY/dot.png\" />\n" +
                    "        <meta property=\"og:secure_url\" content=\"https://i.ibb.co/Jy4nzHY/dot.png\" />\n" +
                    "        <meta property=\"og:url\" content=\"https://www.dotapp.com/view\" />\n" +
                    "        <meta property=\"og:description\" content=\"Dot manage your doodles and social apps\" />\n" +
                    "        <meta property=\"og:site_name\" content=\"Dot\" />\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        <script>\n" +
                    "            document.addEventListener('DOMContentLoaded', function() {\n" +
                    "                console.log('Page loaded');\n" +
                    "            });\n" +
                    "        </script>\n" +
                    "    </body>\n" +
                    "</html>";
        } catch (Exception e) {
            throw new Exception("Error in process build web card: " + e.getMessage(), e);
        }
    }
}

