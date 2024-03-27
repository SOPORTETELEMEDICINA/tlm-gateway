package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.security.ImageUserRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class ImageUserRestFallback extends BaseController implements ImageUserRest {

   private final Logger logger = LoggerFactory.getLogger(ImageUserRestFallback.class);

   @Override
   public Long addImageToUser(UserImageView userImageView, Long userId) {
      logger.error("Error al acceder servicio para agregar nueva imagen a usuario - imagen: {} - ID: {}",
         userImageView, userId);
      return 0L;
   }

   @Override
   public void updateUserImage(UserImageView userImageView, Long userId, Long imageId) {
      logger.error("Error al acceder a servicio para editar imagen de usuario - imagen: {} - userId: {} - imageID: {}",
         userImageView, userId, imageId);
   }

   @Override
   public void deleteImage(Long userId, Long imageId) {
      logger.error("Error al acceder a servicio para eliminar imagen de usuario - userId: {} - imageId: {}", userId, imageId);
   }

   @Override
   public UserImageView getImageByUsername(String username, Boolean small) {
      logger.error("Error al seleccionar imagen de perfil del usuario: {}", username);
      return null;
   }
}