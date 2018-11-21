package com.tolbar.service;

import com.tolbar.modelo.Video;

public interface IVideoService extends IService<Video> {

	public Video buscarClave(String clave);
}
