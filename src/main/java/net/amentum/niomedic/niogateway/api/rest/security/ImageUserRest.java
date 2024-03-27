package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.fallback.security.ImageUserRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserImageView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "http://nio-security", fallback = ImageUserRestFallback.class)
@RequestMapping("users")
public interface ImageUserRest {

   @RequestMapping(value = "{userId}/imageProfile", method = RequestMethod.POST)
   Long addImageToUser(@RequestBody @Validated UserImageView userImageView, @PathVariable("userId") Long userId);

   @RequestMapping(value = "{userId}/imageProfile/{imageId}", method = RequestMethod.PUT)
   void updateUserImage(@RequestBody @Validated UserImageView userImageView, @PathVariable("userId") Long userId, @PathVariable("imageId") Long imageId);

   @RequestMapping(value = "{userId}/imageProfile/{imageId}", method = RequestMethod.DELETE)
   void deleteImage(@PathVariable("userId") Long userId, @PathVariable("imageId") Long imageId);

   @GetMapping("findImageByUsername")
   UserImageView getImageByUsername(@RequestParam(name = "username") String username, @RequestParam(name = "small", required = false, defaultValue = "false") Boolean small);
}
