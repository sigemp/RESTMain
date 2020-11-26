/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component;

/**
 *
 * @author sigem
 */
//////import com.kitfox.svg.SVGDiagram;
//////import com.kitfox.svg.SVGException;
//////import com.kitfox.svg.SVGUniverse;
//////
//////import java.awt.*;
//////import java.awt.image.BufferedImage;
//////import java.net.URL;
//////import java.util.Map;
//////
//////import static java.awt.RenderingHints.*;
//////import java.awt.geom.AffineTransform;
//////import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
//////import java.net.URI;
//////import java.util.HashMap;

/**
 * Responsible for converting SVG images into rasterized PNG images.
 */
public class SvgRasterizer {

//////    public Map<Object, Object> RENDERING_HINTS = new HashMap<>();
//////
//////    private final static SVGUniverse sRenderer = new SVGUniverse();
//////
//////    public SvgRasterizer() {
//////        RENDERING_HINTS.put(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
//////        RENDERING_HINTS.put(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_QUALITY);
//////        RENDERING_HINTS.put(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY);
//////        RENDERING_HINTS.put(KEY_DITHERING, VALUE_DITHER_DISABLE);
//////        RENDERING_HINTS.put(KEY_FRACTIONALMETRICS, VALUE_FRACTIONALMETRICS_ON);
//////        RENDERING_HINTS.put(KEY_INTERPOLATION, VALUE_INTERPOLATION_BICUBIC);
//////        RENDERING_HINTS.put(KEY_RENDERING, VALUE_RENDER_QUALITY);
//////        RENDERING_HINTS.put(KEY_STROKE_CONTROL, VALUE_STROKE_PURE);
//////        RENDERING_HINTS.put(KEY_TEXT_ANTIALIASING, VALUE_TEXT_ANTIALIAS_ON);
//////    }
//////
//////    /**
//////     * Rasterizes a vector graphic to a given size using a
//////     * {@link BufferedImage}. The rendering hints are set to produce high
//////     * quality output.
//////     *
//////     * @param path Fully qualified path to the image resource to rasterize.
//////     * @param dstDim The output image dimensions.
//////     * @return The rasterized {@link Image}.
//////     * @throws SVGException Could not open, read, parse, or render SVG data.
//////     */
//////    public Image rasterize(final URL url, final Dimension dstDim) throws SVGException {
//////        return rasterize(loadDiagram(url), dstDim);
//////    }
//////
//////    public Image rasterize(final String path, final Dimension dstDim) throws SVGException {
//////        return rasterize(loadDiagram(path), dstDim);
//////    }
//////
//////    public Image rasterize(final SVGDiagram diagram, final Dimension dstDim)
//////            throws SVGException {
//////        //final SVGDiagram diagram = loadDiagram(path);
//////        final float wDiagram = diagram.getWidth();
//////        final float hDiagram = diagram.getHeight();
//////        final Dimension srcDim = new Dimension((int) wDiagram, (int) hDiagram);
//////
//////        final Dimension scaled = fit(srcDim, dstDim);
//////        final int wScaled = (int) scaled.getWidth();
//////        final int hScaled = (int) scaled.getHeight();
//////
//////        final BufferedImage image = new BufferedImage(wScaled, hScaled, TYPE_INT_ARGB);
//////
//////        final Graphics2D g = image.createGraphics();
//////        //g.setRenderingHints(RENDERING_HINTS);
//////
//////        final AffineTransform transform = g.getTransform();
//////        transform.setToScale(wScaled / wDiagram, hScaled / hDiagram);
//////
//////        g.setTransform(transform);
//////        diagram.render(g);
//////        g.dispose();
//////
//////        return image;
//////    }
//////
//////    /**
//////     * Gets an instance of {@link URL} that references a file in the
//////     * application's resources.
//////     *
//////     * @param path The full path (starting at the root), relative to the
//////     * application or JAR file's resources directory.
//////     * @return A {@link URL} to the file or {@code null} if the path does not
//////     * point to a resource.
//////     */
//////    private URL getResourceUrl(final String path) {
//////        return SvgRasterizer.class.getResource(path);
//////    }
//////
//////    /**
//////     * Loads the resource specified by the given path into an instance of
//////     * {@link SVGDiagram} that can be rasterized into a bitmap format. The
//////     * {@link SVGUniverse} class will
//////     *
//////     * @param path The full path (starting at the root), relative to the
//////     * application or JAR file's resources directory.
//////     * @return An {@link SVGDiagram} that can be rasterized onto a
//////     * {@link BufferedImage}.
//////     */
//////    private SVGDiagram loadDiagram(final String path) {
//////        final URL url = getResourceUrl(path);
//////        return loadDiagram(url);
//////    }
//////
//////    private SVGDiagram loadDiagram(URL url) {
//////        final URI uri = sRenderer.loadSVG(url);
//////        final SVGDiagram diagram = sRenderer.getDiagram(uri);
//////        return applySettings(diagram);
//////    }
//////
//////    /**
//////     * Instructs the SVG renderer to rasterize the image even if it would be
//////     * clipped.
//////     *
//////     * @param diagram The {@link SVGDiagram} to render.
//////     * @return The same instance with ignore clip heuristics set to
//////     * {@code true}.
//////     */
//////    private SVGDiagram applySettings(final SVGDiagram diagram) {
//////        diagram.setIgnoringClipHeuristic(true);
//////        return diagram;
//////    }
//////
//////    /**
//////     * Scales the given source {@link Dimension} to the destination
//////     * {@link Dimension}, maintaining the aspect ratio with respect to the best
//////     * fit.
//////     *
//////     * @param src The original vector graphic dimensions to change.
//////     * @param dst The desired image dimensions to scale.
//////     * @return The given source dimensions scaled to the destination dimensions,
//////     * maintaining the aspect ratio.
//////     */
//////    private Dimension fit(final Dimension src, final Dimension dst) {
//////        final double srcWidth = src.getWidth();
//////        final double srcHeight = src.getHeight();
//////
//////        // Determine the ratio that will have the best fit.
//////        final double ratio = Math.min(
//////                dst.getWidth() / srcWidth, dst.getHeight() / srcHeight
//////        );
//////
//////        // Scale both dimensions with respect to the best fit ratio.
//////        return new Dimension((int) (srcWidth * ratio), (int) (srcHeight * ratio));
//////    }
}
