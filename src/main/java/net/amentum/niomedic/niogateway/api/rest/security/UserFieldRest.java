package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.UserFieldRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.ExtraFieldView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("fields")
@FeignClient(value = "http://nio-security", fallback = UserFieldRestFallback.class)
public interface UserFieldRest {


   @RequestMapping(method = RequestMethod.GET)
   Page<ExtraFieldView> findPage(@RequestParam(required = false, value = "search", defaultValue = "") String search,
                                 @RequestParam(required = false, value = "profileId") Long profileId,
                                 @RequestParam(required = false, defaultValue = "", value = "legend") String legend,
                                 @RequestParam(required = false, defaultValue = "", value = "date1") String date1,
                                 @RequestParam(required = false, defaultValue = "", value = "date2") String date2,
                                 @RequestParam(required = false, defaultValue = "true", value = "general") Boolean general,
                                 @RequestParam(required = false, defaultValue = "extraFieldId", value = "columnOrder") String columnOrder,
                                 @RequestParam(required = false, defaultValue = "asc", value = "order") String order,
                                 @RequestParam(defaultValue = "0", value = "page") Integer page,
                                 @RequestParam(defaultValue = "25", value = "size") Integer size);


   @RequestMapping(method = RequestMethod.POST)
   void addNewField(@RequestBody @Validated ExtraFieldView view);

   @RequestMapping(method = RequestMethod.PUT, value = "{fieldId}")
   void updateField(@RequestBody @Validated ExtraFieldView view, @PathVariable("fieldId") Long fieldId);

   @RequestMapping(method = RequestMethod.DELETE, value = "{fieldId}")
   void deleteField(@PathVariable("fieldId") Long fieldId);

   @RequestMapping(value = "{fieldId}", method = RequestMethod.GET)
   ExtraFieldView findById(@PathVariable("fieldId") Long fieldId);


   @RequestMapping(value = "byProfileOrActive", method = RequestMethod.GET)
   Collection<ExtraFieldView> findProfileAndActive(@RequestParam(required = false, value = "profileId") Long profileId,
                                                   @RequestParam(required = false, value = "active", defaultValue = "true") Boolean active);


}
