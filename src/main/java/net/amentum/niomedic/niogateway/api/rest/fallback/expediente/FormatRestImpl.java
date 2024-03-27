package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import java.util.List;

import net.amentum.niomedic.expediente.views.FormatResultListView;
import net.amentum.niomedic.expediente.views.FormatResultView;
import net.amentum.niomedic.expediente.views.FormatView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.FormatRest;

public class FormatRestImpl implements FormatRest {

	@Override
	public FormatView addFormat(FormatView view) {
	   return null;
	}

	@Override
	public FormatView editFormat(FormatView view, Long idFormat) {
      return null;
	}

	@Override
	public void deleteFormat(Long idFormat) {
	}

	@Override
	public void updateStatusFormat(Long idFormat) {
	}

	@Override
	public FormatView getDetailsFormat(Long idFormat) {
		return null;
	}

	@Override
	public List<FormatView> getAllFormats() {
		return null;
	}

	@Override
	public Page<FormatView> getFormats(String search, String title, Boolean active, Integer version, Integer page,
			Integer size, String orderColumn, String orderType, Boolean general) {
		return null;
	}

	@Override
	public FormatResultView addFormatResult(FormatResultView formatResultView, Long idFormat) {
      return null;
	}

	@Override
	public List<FormatResultView> getFormatResult(Long idConsulta, Boolean active) {
		return null;
	}

	@Override
	public FormatResultView getFormatResultDetails(Long idFormatResult) {
		return null;
	}

	@Override
	public List<FormatResultListView> getFormatResultView(Long idConsulta) {
		return null;
	}

	@Override
	public List<FormatView> getByIdUsuario(Long idUsuario) {
		return null;
	}

}
