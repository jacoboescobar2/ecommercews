package com.minicommerce.app.util;

import java.util.ArrayList;
import java.util.Collection;
import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

	private static ModelMapper modelMapper;
	
	static {
		modelMapper = new ModelMapper();
	}
	
	public static <S, D> D map(S source, Class<D> destination) throws Exception {
		return modelMapper.map(source, destination);
	}
	
	public static <D, S> Collection<D> mapColletion(final Collection<S> entityCollection, Class<D> destination) throws Exception {
		Collection<D> collection = new ArrayList<>(entityCollection.size());
		entityCollection.forEach(q -> collection.add(modelMapper.map(q, destination)));
		return collection;
	}
	
}
