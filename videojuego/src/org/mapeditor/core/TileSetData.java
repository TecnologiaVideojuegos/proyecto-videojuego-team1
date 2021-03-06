/*-
 * #%L
 * libtiled
 * %%
 * Copyright (C) 2004 - 2018 Thorbj?rn Lindeijer <thorbjorn@lindeijer.nl>
 * %%
 * Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice,
   this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci?n de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder?n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.04.16 a las 09:35:28 PM CEST 
//


package org.mapeditor.core;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * If there are multiple `tileset` elements, they are in ascending<br>
 * order of their `firstgid` attribute. The first tileset always<br>
 * has a `firstgid` value of 1\. Since Tiled 0.15, image collection<br>
 * tilesets do not necessarily number their tiles consecutively<br>
 * since gaps can occur when removing tiles.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TileSet", propOrder = {
    "tileoffset",
    "properties",
    "imageData",
    "terraintypes",
    "internalTiles"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
public class TileSetData {

    /**
     * @since 0.8
     * 
     */
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected TileOffset tileoffset;
    /**
     * @since 0.8
     * 
     */
    @XmlElement(required = true, type = Properties.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected Properties properties;
    /**
     * 
     */
    @XmlElement(name = "image", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected ImageData imageData;
    /**
     * @since 0.9
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected TerrainTypes terraintypes;
    /**
     * 
     */
    @XmlElement(name = "tile", required = true, type = Tile.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected List<Tile> internalTiles;
    /**
     * The first global tile ID of this tileset (this global ID<br>
     * maps to the first tile in this tileset).
     * 
     */
    @XmlAttribute(name = "firstgid")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected Integer firstgid;
    /**
     * The name of this tileset.
     * 
     */
    @XmlAttribute(name = "name")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected String name;
    /**
     * If this tileset is stored in an external TSX (Tile Set XML)<br>
     * file, this attribute refers to that file. That TSX file has<br>
     * the same structure as the element described here. (There is<br>
     * the **firstgid** attribute missing and this source attribute<br>
     * is also not there. These two attributes are kept in the TMX<br>
     * map, since they are map specific.)
     * 
     */
    @XmlAttribute(name = "source")
    @XmlSchemaType(name = "anyURI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected String source;
    /**
     * The (maximum) width of the tiles in this tileset.
     * 
     */
    @XmlAttribute(name = "tilewidth", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected int tileWidth;
    /**
     * The (maximum) height of the tiles in this tileset.
     * 
     */
    @XmlAttribute(name = "tileheight", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected int tileHeight;
    /**
     * The spacing in pixels between the tiles in this tileset<br>
     * (applies to the tileset image).
     * 
     */
    @XmlAttribute(name = "spacing")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected Integer tileSpacing;
    /**
     * The margin around the tiles in this tileset (applies to the<br>
     * tileset image).
     * 
     */
    @XmlAttribute(name = "margin")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected Integer tileMargin;
    /**
     * The number of tiles in this tileset<br>
     * <br>
     * @since 0.13
     * 
     */
    @XmlAttribute(name = "tilecount")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected Integer tilecount;
    /**
     * The number of tile columns in the tileset. For image<br>
     * collection tilesets it is editable and is used when<br>
     * displaying the tileset.<br>
     * <br>
     * @since 0.15
     * 
     */
    @XmlAttribute(name = "columns", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    protected int columns;

    /**
     * @since 0.8
     * 
     * @return
     *     possible object is
     *     {@link TileOffset }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public TileOffset getTileoffset() {
        return tileoffset;
    }

    /**
     * @since 0.8
     * 
     * @param value
     *     allowed object is
     *     {@link TileOffset }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTileoffset(TileOffset value) {
        this.tileoffset = value;
    }

    /**
     * @since 0.8
     * 
     * @return
     *     possible object is
     *     {@link PropertiesData }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public Properties getProperties() {
        return properties;
    }

    /**
     * @since 0.8
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesData }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link ImageData }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public ImageData getImageData() {
        return imageData;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link ImageData }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setImageData(ImageData value) {
        this.imageData = value;
    }

    /**
     * @since 0.9
     * 
     * @return
     *     possible object is
     *     {@link TerrainTypes }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public TerrainTypes getTerraintypes() {
        return terraintypes;
    }

    /**
     * @since 0.9
     * 
     * @param value
     *     allowed object is
     *     {@link TerrainTypes }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTerraintypes(TerrainTypes value) {
        this.terraintypes = value;
    }

    /**
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public List<Tile> getInternalTiles() {
        if (internalTiles == null) {
            internalTiles = new ArrayList<Tile>();
        }
        return this.internalTiles;
    }

    /**
     * The first global tile ID of this tileset (this global ID<br>
     * maps to the first tile in this tileset).
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public Integer getFirstgid() {
        return firstgid;
    }

    /**
     * The first global tile ID of this tileset (this global ID<br>
     * maps to the first tile in this tileset).
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setFirstgid(Integer value) {
        this.firstgid = value;
    }

    /**
     * The name of this tileset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public String getName() {
        return name;
    }

    /**
     * The name of this tileset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * If this tileset is stored in an external TSX (Tile Set XML)<br>
     * file, this attribute refers to that file. That TSX file has<br>
     * the same structure as the element described here. (There is<br>
     * the **firstgid** attribute missing and this source attribute<br>
     * is also not there. These two attributes are kept in the TMX<br>
     * map, since they are map specific.)
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public String getSource() {
        return source;
    }

    /**
     * If this tileset is stored in an external TSX (Tile Set XML)<br>
     * file, this attribute refers to that file. That TSX file has<br>
     * the same structure as the element described here. (There is<br>
     * the **firstgid** attribute missing and this source attribute<br>
     * is also not there. These two attributes are kept in the TMX<br>
     * map, since they are map specific.)
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * The (maximum) width of the tiles in this tileset.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public int getTileWidth() {
        return tileWidth;
    }

    /**
     * The (maximum) width of the tiles in this tileset.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTileWidth(int value) {
        this.tileWidth = value;
    }

    /**
     * The (maximum) height of the tiles in this tileset.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public int getTileHeight() {
        return tileHeight;
    }

    /**
     * The (maximum) height of the tiles in this tileset.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTileHeight(int value) {
        this.tileHeight = value;
    }

    /**
     * The spacing in pixels between the tiles in this tileset<br>
     * (applies to the tileset image).
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public Integer getTileSpacing() {
        return tileSpacing;
    }

    /**
     * The spacing in pixels between the tiles in this tileset<br>
     * (applies to the tileset image).
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTileSpacing(Integer value) {
        this.tileSpacing = value;
    }

    /**
     * The margin around the tiles in this tileset (applies to the<br>
     * tileset image).
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public Integer getTileMargin() {
        return tileMargin;
    }

    /**
     * The margin around the tiles in this tileset (applies to the<br>
     * tileset image).
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTileMargin(Integer value) {
        this.tileMargin = value;
    }

    /**
     * The number of tiles in this tileset<br>
     * <br>
     * @since 0.13
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public Integer getTilecount() {
        return tilecount;
    }

    /**
     * The number of tiles in this tileset<br>
     * <br>
     * @since 0.13
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setTilecount(Integer value) {
        this.tilecount = value;
    }

    /**
     * The number of tile columns in the tileset. For image<br>
     * collection tilesets it is editable and is used when<br>
     * displaying the tileset.<br>
     * <br>
     * @since 0.15
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public int getColumns() {
        return columns;
    }

    /**
     * The number of tile columns in the tileset. For image<br>
     * collection tilesets it is editable and is used when<br>
     * displaying the tileset.<br>
     * <br>
     * @since 0.15
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-04-16T09:35:28+02:00", comments = "JAXB RI v2.2.11")
    public void setColumns(int value) {
        this.columns = value;
    }

}
