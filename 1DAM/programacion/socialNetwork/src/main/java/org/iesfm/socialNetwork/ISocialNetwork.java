package org.iesfm.socialNetwork;

import org.iesfm.socialNetwork.exceptions.AuthorNotFoundException;
import org.iesfm.socialNetwork.exceptions.TagNotFoundException;
import org.iesfm.socialNetwork.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Set;

/**
 * Interface que contiene los metodos que impelementará la SocialNetwork.
 *
 * Metodos: getUserWall, getTagAndUserPosts, addNewUserPost, getAuthorPosts.
 */
public interface ISocialNetwork {

    /**
     * Permite obtener el muro de un determinado usuario.
     *
     * @param userName: nombre del usuario del que se desea obtener su muro (String).
     * @return El muro del ususrio con el userName proporcionado (Set de Post).
     * @throws UserNotFoundException: Cuando el usuario proporcionado no existe en la red social.
     */
    Set<Post> getUserWall(String userName) throws UserNotFoundException;

    /**
     * Permite obtener los post del muro de un determinado usuario que contengan una determinada etiqueta.
     *
     * @param userName: nombre del usuario en cuyo muro se van a buscar los posts (String).
     * @param tag: etiqueta a traves de la cual se van a buscar los posts dentro del muro del usuario (String).
     * @return La coleccion de posts del muro del usuario que contienen la etiqueta proporcionada (Set de Post).
     * @throws UserNotFoundException: Cuando el usuario proporcionado no existe en la red social.
     * @throws TagNotFoundException: Cuando la etiqueta proporcionada no se encuentra en ningun post del muro.
     */
    Set<Post> getTagAndUserPosts (String userName, String tag) throws UserNotFoundException, TagNotFoundException;

    /**
     * Permite añadir un nuevo post en el muro de un usuario.
     *
     * @param userName: nombre del usuario autor del post y en cuyo muro se va a añadir el post (String).
     * @param message: contenido del mensaje del post que se va a añadir (String).
     * @param date: fecha del post (String).
     * @param tags: etiquetas del post (Set de String).
     * @throws UserNotFoundException: Cuando el usuario proporcionado no existe en la red social.
     */
    void addNewUserPost (String userName, String message, String date, Set<String> tags) throws UserNotFoundException;

    /**
     * Permite obtener todos los posts de un determinado autor en la red social.
     * @param userName: nombre del usuario autor de los posts (String).
     * @return La lista de los posts que tienen como autor el nombre proporcionado (List de Post).
     * @throws AuthorNotFoundException: Cuando el autor proporcionado no es autor de ningun post.
     */
    List<Post> getAuthorPosts (String userName) throws AuthorNotFoundException;
}
