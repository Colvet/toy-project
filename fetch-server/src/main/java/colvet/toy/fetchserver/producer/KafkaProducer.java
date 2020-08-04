package colvet.toy.fetchserver.producer;

import colvet.toy.fetchserver.data.CovidDataMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import springfox.documentation.spring.web.json.Json;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, CovidDataMessage> kafkaTemplate;

    private String topic = "covid-data";

    public ListenableFuture<SendResult<String, CovidDataMessage>> sendDataEvent(CovidDataMessage covidDataMessage) {

        String key = "Test";
        CovidDataMessage value = covidDataMessage;

        ProducerRecord<String, CovidDataMessage> producerRecord = new ProducerRecord<>(topic, key, value);

        ListenableFuture<SendResult<String, CovidDataMessage>> listenableFuture = kafkaTemplate.send(producerRecord);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, CovidDataMessage>>() {
            @Override
            public void onFailure(Throwable throwable) {
                handlFailure(key, value, throwable);

            }

            @Override
            public void onSuccess(SendResult<String, CovidDataMessage> stringJSONObjectSendResult) {
                handleSuccess(key, value, stringJSONObjectSendResult);

            }
        });
        return null;
    }



    private void handlFailure(String key, CovidDataMessage value, Throwable ex) {

        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

    private void handleSuccess(String key, CovidDataMessage value, SendResult<String, CovidDataMessage> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value.toString(), result.getRecordMetadata().partition());
    }

}
