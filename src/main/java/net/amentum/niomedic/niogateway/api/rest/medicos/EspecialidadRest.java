package net.amentum.niomedic.niogateway.api.rest.medicos;

import net.amentum.niomedic.medicos.views.EspecialidadView;
import net.amentum.niomedic.niogateway.api.rest.fallback.medicos.EspecialidadRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@FeignClient(value = "http://nio-medicos", fallback = EspecialidadRestImpl.class)
public interface EspecialidadRest {

   @PostMapping("medicos/{idMedico}/especialidad")
   void createEspecialidad(@PathVariable("idMedico") String idMedico, @RequestBody @Validated ArrayList<EspecialidadView> especialidadViewArrayList);

   @PutMapping("medicos/{idMedico}/especialidad")
   void updateEspecialidad(@PathVariable("idMedico") String idMedico, @RequestBody @Validated ArrayList<EspecialidadView> especialidadViewArrayList);

   @DeleteMapping("medicos/{idMedico}/especialidad")
   void deleteEspecialidad(@PathVariable("idMedico") String idMedico, @RequestBody @Validated ArrayList<EspecialidadView> especialidadViewArrayList);

   @PostMapping("medicos/subirCedula/{idMedico}")
   void subirCedula(@RequestParam("file") MultipartFile[] file, @PathVariable("idMedico") String idMedico);

   @PostMapping("medicos/subirDiploma/{idMedico}")
   void subirDiploma(@RequestParam("file") MultipartFile[] file, @PathVariable("idMedico") String idMedico);

}
