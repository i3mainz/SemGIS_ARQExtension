/*******************************************************************************
 * Copyright (c) 2017 Timo Homburg, i3Mainz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BSD License
 * which accompanies this distribution, and is available at
 * https://directory.fsf.org/wiki/License:BSD_4Clause
 *
 * This project extends work by Ian Simmons who developed the Parliament Triple Store.
 * http://parliament.semwebcentral.org and published his work und BSD License as well.
 *
 *     
 *******************************************************************************/
package de.hsmainz.cs.semgis.arqextension.raster;

import java.util.List;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridEnvelope2D;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.jts.GeometryBuilder;
import org.opengis.referencing.operation.TransformException;


import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionEnv;
import com.hp.hpl.jena.vocabulary.XSD;

import de.hsmainz.cs.semgis.arqextension.datatypes.GeoSPARQLLiteral;

public class PixelAsPoint extends RasterSpatialFunction {

	@Override
	protected String[] getRestOfArgumentTypes() {
		// TODO Auto-generated method stub
		return new String[]{XSD.xint.getURI(),XSD.xint.getURI()};
	}

	@Override
	protected NodeValue exec(GridCoverage2D raster, GeoSPARQLLiteral datatype, Binding binding,
			List<NodeValue> evalArgs, String uri, FunctionEnv env) {
		Integer x=evalArgs.get(0).getInteger().intValue();
		Integer y=evalArgs.get(0).getInteger().intValue();
		GeometryBuilder builder=new GeometryBuilder();
		Envelope2D pixelEnvelop;
		try {
			pixelEnvelop = raster.getGridGeometry().gridToWorld(new GridEnvelope2D(x, y, 1, 1));
			return makeNodeValue(builder.point(pixelEnvelop.getCenterX(), pixelEnvelop.getCenterY()),datatype);
		} catch (TransformException e) {
			return NodeValue.nvNothing;
		}
	}

}
