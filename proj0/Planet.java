public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other) {
        double dx = this.xxPos - other.xxPos;
        double dy = this.yyPos - other.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }

    public double calcForceExertedBy(Planet other) {
        double d = calcDistance(other);
        double f = G * this.mass * other.mass / (d * d);
        return f;
    }

    public double calcForceExertedByX(Planet other) {
        double f = calcForceExertedBy(other);
        double d = calcDistance(other);
        double fx = f * (other.xxPos - this.xxPos) / d;
        return fx;
    }

    public double calcForceExertedByY(Planet other) {
        double f = calcForceExertedBy(other);
        double d = calcDistance(other);
        double fy = f * (other.yyPos - this.yyPos) / d;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] others) {
        double total_fx = 0;
        for (Planet other : others) {
            if (this.equals(other))
                continue;
            total_fx += calcForceExertedByX(other);
        }
        return total_fx;
    }

    public double calcNetForceExertedByY(Planet[] others) {
        double total_fy = 0;
        for (Planet other : others) {
            if (this.equals(other))
                continue;
            total_fy += calcForceExertedByY(other);
        }
        return total_fy;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        double vx = this.xxVel + ax * dt;
        double vy = this.yyVel + ay * dt;
        this.xxVel = vx;
        this.yyVel = vy;
        this.xxPos = this.xxPos + vx * dt;
        this.yyPos = this.yyPos + vy * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}