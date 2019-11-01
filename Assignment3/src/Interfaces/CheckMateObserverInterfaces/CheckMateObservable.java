package Interfaces.CheckMateObserverInterfaces;

public interface CheckMateObservable {

    void registerObserver(CheckMateObserver observer);
    void unregisterObserver(CheckMateObserver observer);
    void notifyObservers();
}
