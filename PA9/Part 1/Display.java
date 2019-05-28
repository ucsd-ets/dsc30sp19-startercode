import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Display extends JFrame {

    private JPanel contentPane;
    private JTextField txtCityxytxt;
    private JTextField txtCitypairstxt;
    private GraphPanel panel;
    private JComboBox<String> weightedStartCityComboBox;
    private JComboBox<String> weightedEndCityComboBox;
    private Graph graph;
    private JCheckBox chckbxShowEdgeWeights;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Display frame = new Display();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Graph readGraph(String vertexFile, String edgeFile) {

        Graph graph = new Graph();
        try {
            String line;
            // Read in the vertices
            BufferedReader vertexFileBr = new BufferedReader(new FileReader(vertexFile));
            while ((line = vertexFileBr.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    vertexFileBr.close();
                    throw new IOException("Invalid line in vertex file " + line);
                }
                String cityname = parts[0];
                int x = Integer.valueOf(parts[1]);
                int y = Integer.valueOf(parts[2]);
                Vertex vertex = new Vertex(cityname, x, y);
                graph.addVertex(vertex);
            }
            vertexFileBr.close();
            // Now read in the edges
            BufferedReader edgeFileBr = new BufferedReader(new FileReader(edgeFile));
            while ((line = edgeFileBr.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    edgeFileBr.close();
                    throw new IOException("Invalid line in edge file " + line);
                }
                graph.addUndirectedEdge(parts[0], parts[1], Double.parseDouble(parts[2]));
            }
            edgeFileBr.close();
        } catch (IOException e) {
            System.err.println("Could not read the graph: " + e);
            return null;
        }
        return graph;
    }

    /**
     * Create the frame.
     */
    public Display() {
        setTitle("Graph Traversal Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 1000, 900);
        setMinimumSize(new Dimension(800, 600));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        graph = readGraph("cityxy.txt", "citypairs.txt");

        panel = new GraphPanel(graph);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 7;
        gbc_panel.insets = new Insets(0, 0, 7, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);

        JSeparator separator = new JSeparator();
        separator.setBackground(Color.WHITE);
        separator.setForeground(Color.GRAY);
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.fill = GridBagConstraints.BOTH;
        gbc_separator.gridwidth = 6;
        gbc_separator.insets = new Insets(0, 0, 5, 0);
        gbc_separator.gridx = 0;
        gbc_separator.gridy = 2;
        contentPane.add(separator, gbc_separator);

        chckbxShowEdgeWeights = new JCheckBox("Show Edge Weights");
        chckbxShowEdgeWeights.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                repaint();
            }
        });

        JLabel lblReloadGraph = new JLabel("Input files");
        GridBagConstraints gbc_lblReloadGraph = new GridBagConstraints();
        gbc_lblReloadGraph.anchor = GridBagConstraints.EAST;
        gbc_lblReloadGraph.insets = new Insets(0, 0, 5, 5);
        gbc_lblReloadGraph.gridx = 0;
        gbc_lblReloadGraph.gridy = 3;
        contentPane.add(lblReloadGraph, gbc_lblReloadGraph);

        txtCityxytxt = new JTextField();
        txtCityxytxt.setText("cityxy.txt");
        GridBagConstraints gbc_txtCityxytxt = new GridBagConstraints();
        gbc_txtCityxytxt.gridwidth = 1;
        gbc_txtCityxytxt.insets = new Insets(0, 0, 5, 5);
        gbc_txtCityxytxt.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCityxytxt.gridx = 1;
        gbc_txtCityxytxt.gridy = 3;
        contentPane.add(txtCityxytxt, gbc_txtCityxytxt);
        txtCityxytxt.setColumns(10);

        txtCitypairstxt = new JTextField();
        txtCitypairstxt.setText("citypairs.txt");
        GridBagConstraints gbc_txtCitypairstxt = new GridBagConstraints();
        gbc_txtCitypairstxt.gridwidth = 1;
        gbc_txtCitypairstxt.insets = new Insets(0, 0, 5, 5);
        gbc_txtCitypairstxt.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCitypairstxt.gridx = 2;
        gbc_txtCitypairstxt.gridy = 3;
        contentPane.add(txtCitypairstxt, gbc_txtCitypairstxt);
        txtCitypairstxt.setColumns(10);

        JButton btnReloadGraph = new JButton("Load / Reset");
        GridBagConstraints gbc_btnReloadGraph = new GridBagConstraints();
        gbc_btnReloadGraph.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnReloadGraph.insets = new Insets(0, 0, 5, 0);
        gbc_btnReloadGraph.gridx = 3;
        gbc_btnReloadGraph.gridy = 3;
        contentPane.add(btnReloadGraph, gbc_btnReloadGraph);

        btnReloadGraph.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                updateGraphPanel();
            }
        });

        JLabel lblEuclideanDistances = new JLabel("Euclidean Distances");
        GridBagConstraints gbc_lblEuclideanDistances = new GridBagConstraints();
        gbc_lblEuclideanDistances.anchor = GridBagConstraints.EAST;
        gbc_lblEuclideanDistances.insets = new Insets(0, 0, 5, 5);
        gbc_lblEuclideanDistances.gridx = 0;
        gbc_lblEuclideanDistances.gridy = 4;
        contentPane.add(lblEuclideanDistances, gbc_lblEuclideanDistances);

        chckbxShowEdgeWeights.setSelected(true);
        GridBagConstraints gbc_chckbxShowEdgeWeights = new GridBagConstraints();
        gbc_chckbxShowEdgeWeights.anchor = GridBagConstraints.WEST;
        gbc_chckbxShowEdgeWeights.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxShowEdgeWeights.gridx = 1;
        gbc_chckbxShowEdgeWeights.gridy = 4;
        contentPane.add(chckbxShowEdgeWeights, gbc_chckbxShowEdgeWeights);

        JButton btnComputeAllEuclidean = new JButton("Compute All Euclidean Distances");
        GridBagConstraints gbc_btnComputeAllEuclidean = new GridBagConstraints();
        gbc_btnComputeAllEuclidean.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnComputeAllEuclidean.insets = new Insets(0, 0, 5, 0);
        gbc_btnComputeAllEuclidean.gridx = 2;
        gbc_btnComputeAllEuclidean.gridy = 4;
        contentPane.add(btnComputeAllEuclidean, gbc_btnComputeAllEuclidean);

        btnComputeAllEuclidean.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                panel.graph.computeAllEuclideanDistances();
                repaint();
            }
        });

        JLabel lblGetWeightedShortest_1 = new JLabel("Graph Traversal Algorithm");
        GridBagConstraints gbc_lblGetWeightedShortest_1 = new GridBagConstraints();
        gbc_lblGetWeightedShortest_1.anchor = GridBagConstraints.EAST;
        gbc_lblGetWeightedShortest_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblGetWeightedShortest_1.gridx = 0;
        gbc_lblGetWeightedShortest_1.gridy = 5;
        contentPane.add(lblGetWeightedShortest_1, gbc_lblGetWeightedShortest_1);

        JLabel lblStart_1 = new JLabel("Start");
        GridBagConstraints gbc_lblStart_1 = new GridBagConstraints();
        gbc_lblStart_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblStart_1.anchor = GridBagConstraints.CENTER;
        gbc_lblStart_1.gridx = 1;
        gbc_lblStart_1.gridy = 5;
        contentPane.add(lblStart_1, gbc_lblStart_1);

        weightedStartCityComboBox = new JComboBox<>();
        weightedStartCityComboBox.setToolTipText("");
        GridBagConstraints gbc_weightedStartCityComboBox = new GridBagConstraints();
        gbc_weightedStartCityComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_weightedStartCityComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_weightedStartCityComboBox.gridx = 1;
        gbc_weightedStartCityComboBox.gridy = 6;
        contentPane.add(weightedStartCityComboBox, gbc_weightedStartCityComboBox);

        JLabel lblEnd_1 = new JLabel("End");
        GridBagConstraints gbc_lblEnd_1 = new GridBagConstraints();
        gbc_lblEnd_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblEnd_1.anchor = GridBagConstraints.CENTER;
        gbc_lblEnd_1.gridx = 2;
        gbc_lblEnd_1.gridy = 5;
        contentPane.add(lblEnd_1, gbc_lblEnd_1);

        weightedEndCityComboBox = new JComboBox<>();
        GridBagConstraints gbc_weightedEndCityComboBox = new GridBagConstraints();
        gbc_weightedEndCityComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_weightedEndCityComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_weightedEndCityComboBox.gridx = 2;
        gbc_weightedEndCityComboBox.gridy = 6;
        contentPane.add(weightedEndCityComboBox, gbc_weightedEndCityComboBox);

        JButton btnDrawDFS = new JButton("Draw DFS's Path");
        btnDrawDFS.setForeground(Color.BLUE);
        GridBagConstraints gbc_btnDrawDFS = new GridBagConstraints();
        gbc_btnDrawDFS.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDrawDFS.insets = new Insets(0, 0, 5, 0);
        gbc_btnDrawDFS.gridx = 1;
        gbc_btnDrawDFS.gridy = 7;
        contentPane.add(btnDrawDFS, gbc_btnDrawDFS);

        JButton btnDrawBFS = new JButton("Draw BFS's Path");
        btnDrawBFS.setForeground(Color.BLUE);
        GridBagConstraints gbc_btnDrawBFS = new GridBagConstraints();
        gbc_btnDrawBFS.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDrawBFS.insets = new Insets(0, 0, 5, 0);
        gbc_btnDrawBFS.gridx = 2;
        gbc_btnDrawBFS.gridy = 7;
        contentPane.add(btnDrawBFS, gbc_btnDrawBFS);

        JButton btnDrawDijkstra = new JButton("Draw Dijkstra's Path");
        btnDrawDijkstra.setForeground(Color.BLUE);
        GridBagConstraints gbc_btnDrawDijkstra = new GridBagConstraints();
        gbc_btnDrawDijkstra.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDrawDijkstra.insets = new Insets(0, 0, 5, 0);
        gbc_btnDrawDijkstra.gridx = 1;
        gbc_btnDrawDijkstra.gridy = 8;
        contentPane.add(btnDrawDijkstra, gbc_btnDrawDijkstra);

        JButton btnDrawAStar = new JButton("Draw A*'s Path");
        btnDrawAStar.setForeground(Color.BLUE);
        GridBagConstraints gbc_btnDrawAStar = new GridBagConstraints();
        gbc_btnDrawAStar.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDrawAStar.insets = new Insets(0, 0, 5, 0);
        gbc_btnDrawAStar.gridx = 2;
        gbc_btnDrawAStar.gridy = 8;
        contentPane.add(btnDrawAStar, gbc_btnDrawAStar);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.GRAY);
        separator_1.setBackground(Color.WHITE);
        GridBagConstraints gbc_separator_1 = new GridBagConstraints();
        gbc_separator_1.fill = GridBagConstraints.BOTH;
        gbc_separator_1.gridwidth = 6;
        gbc_separator_1.insets = new Insets(0, 0, 5, 0);
        gbc_separator_1.gridx = 0;
        gbc_separator_1.gridy = 9;
        contentPane.add(separator_1, gbc_separator_1);

        btnDrawDFS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String startCity = weightedStartCityComboBox.getItemAt(weightedStartCityComboBox.getSelectedIndex());
                String endCity = weightedEndCityComboBox.getItemAt(weightedEndCityComboBox.getSelectedIndex());
                System.out.println("Calculating shortest weighted path for " + startCity + " to " + endCity);
                graph.DFS(startCity, endCity);
                List<Edge> path = graph.getPath(startCity, endCity);
                panel.overlayEdges.put("weighted", path);
                repaint();
            }
        });
        btnDrawBFS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String startCity = weightedStartCityComboBox.getItemAt(weightedStartCityComboBox.getSelectedIndex());
                String endCity = weightedEndCityComboBox.getItemAt(weightedEndCityComboBox.getSelectedIndex());
                System.out.println("Calculating shortest weighted path for " + startCity + " to " + endCity);
                graph.BFS(startCity, endCity);
                List<Edge> path = graph.getPath(startCity, endCity);
                panel.overlayEdges.put("weighted", path);
                repaint();
            }
        });
        btnDrawDijkstra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String startCity = weightedStartCityComboBox.getItemAt(weightedStartCityComboBox.getSelectedIndex());
                String endCity = weightedEndCityComboBox.getItemAt(weightedEndCityComboBox.getSelectedIndex());
                System.out.println("Calculating shortest weighted path for " + startCity + " to " + endCity);
                graph.Dijkstra(startCity, endCity);
                List<Edge> path = graph.getPath(startCity, endCity);
                panel.overlayEdges.put("weighted", path);
                repaint();
            }
        });
        btnDrawAStar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String startCity = weightedStartCityComboBox.getItemAt(weightedStartCityComboBox.getSelectedIndex());
                String endCity = weightedEndCityComboBox.getItemAt(weightedEndCityComboBox.getSelectedIndex());
                System.out.println("Calculating shortest weighted path for " + startCity + " to " + endCity);
                graph.AStar(startCity, endCity);
                List<Edge> path = graph.getPath(startCity, endCity);
                panel.overlayEdges.put("weighted", path);
                repaint();
            }
        });


        updateGraphPanel();
    }

    private void updateGraphPanel() {
        String vertexFile = txtCityxytxt.getText();
        String edgeFile = txtCitypairstxt.getText();
        graph = readGraph(vertexFile, edgeFile);
        panel.graph = graph;
        System.out.println("Constructing new file from " + vertexFile + " and " + edgeFile);
        System.out.println("Data read: " + panel.graph.getVertices());

        String[] cityNames = graph.getVertices().parallelStream().map(v -> v.getName()).sorted().toArray(String[]::new);
        weightedStartCityComboBox.setModel(new DefaultComboBoxModel<>(cityNames));
        weightedEndCityComboBox.setModel(new DefaultComboBoxModel<>(cityNames));

        panel.overlayEdges.put("weighted", new LinkedList<Edge>());
        panel.overlayEdges.put("unweighted", new LinkedList<Edge>());
        panel.overlayEdges.put("mst", new LinkedList<Edge>());

        repaint();
    }

    public class GraphPanel extends JPanel {

        // layout parameters
        public static final int VERTEX_RADIUS = 5;
        public static final int SPACE = 3;

        public static final int MARGIN_X = 50;
        public static final int MARGIN_Y = 50;

        public static final int DEFAULT_THICKNESS = 1;

        public float xFactor, yFactor;

        public Graph graph;

        public HashMap<String, List<Edge>> overlayEdges;

        public GraphPanel(Graph graph) {
            this.graph = graph;
            overlayEdges = new HashMap<>();
            overlayEdges.put("weighted", new LinkedList<Edge>());
            overlayEdges.put("unweighted", new LinkedList<Edge>());
            overlayEdges.put("mst", new LinkedList<Edge>());
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

            int minX = 0;
            int maxX = 1;
            int minY = 0;
            int maxY = 1;
            for (Vertex v : graph.getVertices()) {
                if (v.getX() < minX)
                    minX = v.getX();
                if (v.getX() > maxX)
                    maxX = v.getX();
                if (v.getY() < minY)
                    minY = v.getY();
                if (v.getY() > maxY)
                    maxY = v.getY();
            }
            xFactor = (this.getBounds().width - 2 * MARGIN_X) / (float) (maxX - minX);
            yFactor = (this.getBounds().height - 2 * MARGIN_Y) / (float) (maxY - minY);
            super.paintComponent(g2);
            paintGraph(g2);
        }

        public void paintGraph(Graphics g) {
            // TODO: for each edge in the graph, use paintEdge(g, edge.source, edge.target, edge.distance, Color.LIGHT_GRAY, DEFAULT_THICKNESS, 255); to print the edge.

            // TODO: for each vertex in the graph, use paintVertex(g, v); to print the vertex

            for (String overlayType : overlayEdges.keySet()) {
                if (overlayType.equals("unweighted")) {
                    for (Edge edge : overlayEdges.get(overlayType)) {
                        paintEdge(g, edge.getSource(), edge.getTarget(), edge.getDistance(), Color.RED, 8, 50);
                    }
                }
                if (overlayType.equals("weighted")) {
                    for (Edge edge : overlayEdges.get(overlayType)) {
                        paintEdge(g, edge.getSource(), edge.getTarget(), edge.getDistance(), Color.GREEN, 8, 50);
                    }
                }
            }
        }

        public void paintVertex(Graphics g, Vertex v) {
            Graphics2D g2 = (Graphics2D) g;

            int x = Math.round(xFactor * (float) v.getX() + (float) MARGIN_X);
            int y = Math.round(yFactor * (float) v.getY() + (float) MARGIN_Y);
            g2.setColor(Color.LIGHT_GRAY);
            Stroke oldStroke = g2.getStroke();
            g2.setStroke(new BasicStroke(4));
            g2.drawOval(x - VERTEX_RADIUS / 2, y - VERTEX_RADIUS / 2, VERTEX_RADIUS, VERTEX_RADIUS);
            g2.setStroke(oldStroke);
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillOval(x - VERTEX_RADIUS / 2, y - VERTEX_RADIUS / 2, VERTEX_RADIUS, VERTEX_RADIUS);
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(v.getName(), x - v.getName().length() * 8 / 2, y + VERTEX_RADIUS / 2);
        }

        public void paintEdge(Graphics g, Vertex u, Vertex v, double weight, Color color, int thickness, int alpha) {
            Graphics2D g2 = (Graphics2D) g;
            int x1 = Math.round(xFactor * (float) u.getX() + (float) MARGIN_X);
            int y1 = Math.round(yFactor * (float) u.getY() + (float) MARGIN_Y);
            int x2 = Math.round(xFactor * (float) v.getX() + (float) MARGIN_X);
            int y2 = Math.round(yFactor * (float) v.getY() + (float) MARGIN_Y);
            g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
            Stroke oldStroke = g2.getStroke();
            g2.setStroke(new BasicStroke(thickness));
            g2.drawLine(x1, y1, x2, y2);
            g2.setStroke(oldStroke);
            if (chckbxShowEdgeWeights.isSelected()) {
                Font oldFont = g2.getFont();
                g2.setFont(new Font("Helvetica", Font.PLAIN, 8));
                g2.setColor(Color.GRAY);
                g2.drawString(String.format("%.1f", weight), (x1 + x2) / 2, (y1 + y2) / 2);
                g2.setFont(oldFont);
            }
        }
    }
}
