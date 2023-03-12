import kotlin.random.Random
import java.util.*
import java.io.*
import java.nio.file.Path
import kotlin.math.*
import kotlin.io.relativeTo

fun readFileToList(fileName: String) : ArrayList<String> {
    val list = arrayListOf<String>()
        File(fileName).forEachLine { list.add(it) }
    return list
}

//fun readFileUsingGetResource(fileName: String)
//        = this::class.java.getResource(fileName).readText(Charsets.UTF_8)

class Point(x: Int, y: Int) {
    private var x: Int;
    private var y : Int;

    init {
        this.x = x;
        this.y = y;
    }

    companion object RandomPoint {
        fun generateRandom(from: Int, to: Int): Point{
            val x: Int = Random.nextInt(from, to)
            val y: Int = Random.nextInt(from, to)
            return Point(x, y)
        }
    }


    fun setX(x: Int) { this.x = x; }

    fun setY(y: Int) { this.y = y; }

    fun getX () : Int { return this.x }

    fun getY () : Int { return this.y }

    fun move(dx: Int, dy: Int) {
        setX(this.x - dx);
        setY(this.y - dy);
    }

    fun move(line: Line) {
        val dx = line.getDX();
        val dy = line.getDY();
        this.move(dx, dy);
    }

    override fun toString() : String {
        return "Point($x,$y)";
    }
}

class Line (p1: Point, p2: Point) {
    private var p1: Point;
    private var p2: Point;

    init {
        this.p1 = p1;
        this.p2 = p2;
    }

    constructor(x1: Int, y1: Int, x2: Int, y2: Int) : this(Point(x1, y1), Point(x2, y2))

    fun getP1(): Point { return this.p1 }

    fun getP2(): Point { return this.p2 }

    fun getDX(): Int { return this.getP1().getX() - this.getP2().getX(); }

    fun getDY(): Int { return this.getP1().getY() - this.getP2().getY(); }

    override fun toString() : String {
        return "Line($p1->$p2)"
    }
}

class Student(firstName: String, lastName: String) {
    private var firstName: String
    private var lastName: String
    private val id: Int

    init {
        this.firstName = firstName
        this.lastName = lastName
        this.id = UUID.randomUUID().hashCode().absoluteValue
    }

    fun getFirstName(): String { return this.firstName }

    fun getLastName(): String { return this.lastName }

    fun getID(): Int { return this.id }

    fun setFirstName(firstName: String) { this.firstName = firstName }

    fun setLastName(lastName: String) { this.lastName = lastName }

    override fun toString(): String { return "Student($firstName $lastName, $id)"}

}

fun main() {
    // Part I
    println("Part I:")
    var numberOfPointsToGenerate = 3
    val bounds = 10
    val points = arrayListOf<Point>()

    while (numberOfPointsToGenerate > 0) {
        val newPoint: Point = Point.generateRandom(-bounds, bounds)
        println(newPoint.toString())
        points.add(newPoint)
        numberOfPointsToGenerate--
    }
    val p1 = Point(0, 0)
    val p2 = Point.generateRandom(-bounds/2, bounds/2)
    val vector = Line(p1, p2)
    println("Vector: $vector")

    points.forEach() {
        it.move(vector)
        println(it)
    }

    // Part II
    println("\nPart II:")

    // Part III
    println("\nPart III:")
    var numberOfStudentsToGenerate = 5

    val absPath = Path.of("").toAbsolutePath()
    val pathToFirstNames = "$absPath/src/main/kotlin/firstNames.txt/"
    val pathToLastNames = "$absPath/src/main/kotlin/lastNames.txt/"

    val firstNames = readFileToList(pathToFirstNames)
    val lastNames = readFileToList(pathToLastNames)

    val students = arrayListOf <Student>()

    while (numberOfStudentsToGenerate > 0) {
        val firstName: String = firstNames.random()
        val lastName: String = lastNames.random()
        val student = Student(firstName,lastName)
        students.add(student)
        numberOfStudentsToGenerate--
    }

    students.forEach() { println(it) }
}
