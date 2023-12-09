package ma.xproce.inventoryservice.web;

import lombok.AllArgsConstructor;
import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import ma.xproce.inventoryservice.dtos.CreatorRequest;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class VideoGraphQlController {
    private CreatorManager creatorManager ;
    private VideoManager videoManager  ;


    @QueryMapping
    public List<Video> videoList(){
        return creatorManager.videoList();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorManager.creatorById(id);
    }

    @MutationMapping
    public Video saveVideo(@Argument Video video){
        return videoManager.saveVideo(video);
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest CreatorRequest){
        return creatorManager.saveCreator(CreatorRequest);
    }

    @QueryMapping
    public CreatorRequest getCreator(@Argument Long id){
      return   creatorManager.getCreator(id);
    }
/*
    @SubscriptionMapping
    public List<Creator> getCreatorData(){
        return creatorRepository.findAll();
    }*/
}