package com.tolbar.api;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tolbar.modelo.Video;
import com.tolbar.service.IVideoService;

@RestController
@RequestMapping("/api/video")
public class ControladorVideoRest {

	@Autowired
	private IVideoService servicioVideo;

	@RequestMapping(value = "/obtener", method = RequestMethod.GET, produces = "video/mp4")
	public FileSystemResource obtener(@RequestParam("clave") String clave) {

		Video video = servicioVideo.buscarClave(clave);

		if (video != null) {
			servicioVideo.eliminar(video.getId());
			File fileMp4 = new File("C:\\Users\\BARTOL\\Videos\\video.mp4");
			return new FileSystemResource(fileMp4);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/generarClave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String generarClave() {

		String random = UUID.randomUUID().toString();
		servicioVideo.registrar(new Video(random));
		return random;
	}

}
