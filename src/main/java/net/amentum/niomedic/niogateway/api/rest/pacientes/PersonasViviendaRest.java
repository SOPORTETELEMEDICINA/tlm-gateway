package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.PersonasViviendaRestImpl;
import net.amentum.niomedic.pacientes.views.PersonasViviendaView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = PersonasViviendaRestImpl.class)
public interface PersonasViviendaRest {

   @PostMapping("pacientes/{idPaciente}/personas-vivienda")
   void createPersonasVivienda(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<PersonasViviendaView> personasViviendaViewArrayList);

   @PutMapping("pacientes/{idPaciente}/personas-vivienda")
   void updatePersonasVivienda(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<PersonasViviendaView> personasViviendaViewArrayList);

   @DeleteMapping("pacientes/{idPaciente}/personas-vivienda")
   void deletePersonasVivienda(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<PersonasViviendaView> personasViviendaViewArrayList);

}
