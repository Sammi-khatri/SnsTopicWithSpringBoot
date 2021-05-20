package sam.sns.topic.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnsController {

    @Value("${snsTopicName}")
    private String topicArn;
    @Autowired
    AmazonSNSClient snsClient;
    @PostMapping("/telecast/message")
    public String telecastMessage(@RequestBody String message){
        PublishRequest request=new PublishRequest(topicArn,"topicMessage","subject");
        snsClient.publish(request);
        return "Message published";
    }
}
