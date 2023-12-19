package sau.demo.Core.Utilites.Results;

public class ErrorResult extends Result{
    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false, message);
    }
}
