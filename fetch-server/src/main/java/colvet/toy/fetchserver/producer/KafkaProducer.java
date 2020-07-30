package colvet.toy.fetchserver.producer;

import colvet.toy.fetchserver.model.GubunResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import springfox.documentation.spring.web.json.Json;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    KafkaTemplate<String, Json> kafkaTemplate;

    private String topic = "covid-data";

//    public ListenableFuture<SendResult<String, Json>> sendDataEvent(GubunResponseModel gubunResponseModel){
//        if(fileEvent.getResultLocation() == null){
//            String key = fileEvent.getResultFileName();
//            String value = objectMapper.writeValueAsString(fileEvent);
//
//            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
//
//            ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(producerRecord);
//
//            listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//                @Override
//                public void onFailure(Throwable throwable) {
//                    handleFailure(key, value, throwable);
//
//                }
//
//                @Override
//                public void onSuccess(SendResult<String, String> stringStringSendResult) {
//                    handleSuccess(key, value, stringStringSendResult);
//                }
//            });
//        }else{
//            String key = fileEvent.getResultFileName();
//            String dir = fileEvent.getResultLocation();
//            fileEvent.setResultLocation(null);
//            InputStreamReader is = new InputStreamReader(new FileInputStream(dir), "UTF-8");
//            is.write(0xEF);


//            FileEvent startEvent = new FileEvent();
//            startEvent.setFileEventType(FileEventType.CREATE);
//            startEvent.setResultFileName(fileEvent.getResultFileName());
//            String startvalue = objectMapper.writeValueAsString(startEvent);
//            log.info("startvalue:{}",startvalue);
//            kafkaTemplate.send(topic, key, startvalue);
//
//            for (String[] str : csvList){
//
//                fileEvent.setData(Arrays.toString(str));
//                String value = objectMapper.writeValueAsString(fileEvent);
//
//                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
//
//                ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(producerRecord);
//                listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//                    @Override
//                    public void onFailure(Throwable throwable) {
//                        handleFailure(key, value, throwable);
//
//                    }
//
//                    @Override
//                    public void onSuccess(SendResult<String, String> stringStringSendResult) {
//                        handleSuccess(key, value, stringStringSendResult);
//                    }
//                });
//
//            }
//            FileEvent endFileEvent = new FileEvent();
//            endFileEvent.setFileEventType(FileEventType.END);
//
//            String value = objectMapper.writeValueAsString(endFileEvent);
//            kafkaTemplate.send(topic, key, value);



//        }
//
//        return null;
//    }



    private void handleFailure(String key, Json value, Throwable ex) {

        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

    private void handleSuccess(String key, String value, SendResult<String, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }

}
