package org.iesfm.socialNetwork;

import org.iesfm.socialNetwork.exceptions.AuthorNotFoundException;
import org.iesfm.socialNetwork.exceptions.TagNotFoundException;
import org.iesfm.socialNetwork.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Set;

public interface ISocialNetwork {

    Set<Post> getUserWall(String userName) throws UserNotFoundException;

    Set<Post> getTagAndUserPosts (String userName, String tag) throws UserNotFoundException, TagNotFoundException;

    void addNewUserPost (String userName, String message, String date, Set<String> tags) throws UserNotFoundException;

    List<Post> getAuthorPosts (String userName) throws AuthorNotFoundException;
}
