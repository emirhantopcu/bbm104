public abstract class Examination {
    String description = "";
    String getDescription(){                //Decorative Pattern for examinations and operations
        return description;
    }
    abstract int getCost();
}

class Inpatient extends Examination{
    public Inpatient() {
        description = "Inpatient\t";
    }

    @Override
    int getCost() {
        return 10;
    }
}

class Outpatient extends Examination{
    public Outpatient() {
        description = "Outpatient\t";
    }

    @Override
    int getCost() {
        return 15;
    }
}

abstract class OperationDecorator extends Examination{
    protected Examination examination;

    public OperationDecorator(Examination examination) {
        this.examination = examination;
    }
}

class DoctorVisit extends OperationDecorator{

    public DoctorVisit(Examination examination) {
        super(examination);
        description = examination.getDescription() + "doctorvisit ";

    }

    @Override
    int getCost() {
        return 15 + examination.getCost();
    }
}

class Imaging extends OperationDecorator{

    public Imaging(Examination examination) {
        super(examination);
        description = examination.getDescription() + "imaging ";
    }



    @Override
    int getCost() {
        return 10 + examination.getCost();
    }
}

class Tests extends OperationDecorator{

    public Tests(Examination examination) {
        super(examination);
        description = examination.getDescription() + "tests ";
    }



    @Override
    int getCost() {
        return 7 + examination.getCost();
    }
}

class Measurements extends OperationDecorator{

    public Measurements(Examination examination) {
        super(examination);
        description = examination.getDescription() + "measurements ";
    }


    @Override
    int getCost() {
        return 5 + examination.getCost();
    }
}

