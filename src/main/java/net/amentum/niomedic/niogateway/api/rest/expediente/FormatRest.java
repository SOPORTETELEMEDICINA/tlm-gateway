package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.FormatResultListView;
import net.amentum.niomedic.expediente.views.FormatResultView;
import net.amentum.niomedic.expediente.views.FormatView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.FormatRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("formats")
@FeignClient(value = "http://nio-expediente", fallback = FormatRestImpl.class)
public interface FormatRest {

   @PostMapping()
   FormatView addFormat(@RequestBody @Validated FormatView view);

   @PutMapping("{idFormat}")
   FormatView editFormat(@RequestBody @Validated FormatView view, @PathVariable("idFormat") Long idFormat);

   @DeleteMapping("{idFormat}")
   void deleteFormat(@PathVariable("idFormat") Long idFormat);

   @PutMapping("status/{idFormat}")
   void updateStatusFormat(@PathVariable("idFormat") Long idFormat);

   @GetMapping("{idFormat}")
   FormatView getDetailsFormat(@PathVariable("idFormat") Long idFormat);

   @GetMapping(value = "all")
   List<FormatView> getAllFormats();

   @GetMapping()
   Page<FormatView> getFormats(@RequestParam(required = false, name = "search") String search,
                               @RequestParam(required = false, name = "title") String title,
                               @RequestParam(required = false, name = "active") Boolean active,
                               @RequestParam(required = false, name = "version") Integer version,
                               @RequestParam(required = false, name = "page") Integer page,
                               @RequestParam(required = false, name = "size") Integer size,
                               @RequestParam(required = false, name = "orderColumn") String orderColumn,
                               @RequestParam(required = false, name = "orderType") String orderType,
                               @RequestParam(required = false, defaultValue = "false", name = "general") Boolean general);

   @PostMapping(value = "result/{idFormat}")
   FormatResultView addFormatResult(@RequestBody @Validated FormatResultView formatResultView, @PathVariable("idFormat") Long idFormat);

   @GetMapping("result")
   List<FormatResultView> getFormatResult(@RequestParam(required = false, name = "idConsulta") Long idConsulta, @RequestParam(required = false, name = "active") Boolean active);

   @GetMapping("result/{idFormatResult}")
   FormatResultView getFormatResultDetails(@PathVariable("idFormatResult") Long idFormatResult);

   @GetMapping("result/list")
   List<FormatResultListView> getFormatResultView(@RequestParam(required = false, value = "idConsulta") Long idConsulta);

   @GetMapping("user/{idUsuario}")
   List<FormatView> getByIdUsuario(@PathVariable("idUsuario") Long idUsuario);

}
