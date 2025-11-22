package org.firstinspires.ftc.teamcode.Sensing;
import com.acmerobotics.dashboard.config.Config;

@Config
public class FieldCoredinates {
    public static final double NORTH = 0;
    public static final double WEST = Math.toRadians(90);
    public static final double SOUTH = Math.toRadians(180);
    public static final double EAST = Math.toRadians(-90);
    public static final double NORTHWEST = Math.toRadians(45);
    public static final double NORTHEAST = Math.toRadians(-45);

    public static final double PanelWidth = 23.5;

    public static final double A = (PanelWidth/2) * 5;
    public static final double B = (PanelWidth/2) * 3;
    public static final double C = (PanelWidth/2) * 1;
    public static final double D = (PanelWidth/2) * -1;
    public static final double E = (PanelWidth/2) * -3;
    public static final double F = (PanelWidth/2) * -5;
    public static final double I = (PanelWidth/2) * -5;
    public static final double II = (PanelWidth/2) * -3;
    public static final double III = (PanelWidth/2) * -1;
    public static final double IV = (PanelWidth/2) * 1;
    public static final double V = (PanelWidth/2) * 3;
    public static final double VI = (PanelWidth/2) * 5;
}
