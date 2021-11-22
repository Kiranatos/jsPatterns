Команда Command или Action, Transaction
Тип: поведенческий
Назначение: для обработки команды в виде объекта
Родственные шаблоны: Компоновщик, Хранитель, Прототип, Одиночка
Command Pattern JDK Example: Runnable interface (java.lang.Runnable) and Swing Action (javax.swing.Action) uses command pattern.
My Questions: может ли быть несколько Invoker-ов, которые имеют общих Command&?

Important Points:
- Command is the core of this pattern that defines the contract for implementation.
- Receiver implementation is separate from command implementation.
- Command implementation classes chose the method to invoke on receiver object, for every method in receiver there will be a command implementation. It works as a bridge between receiver and action methods.
- Invoker class just forward the request from client to the command object.
- Client is responsible to instantiate appropriate command and receiver implementation and then associate them together.
- Client is also responsible for instantiating invoker object and associating command object with it and execute the action method.
- Command pattern is easily extendible, we can add new action methods in receivers and create new Command implementations without changing the client code.
- The drawback with Command pattern is that the code gets huge and confusing with high number of action methods and because of so many associations.

(e-example from elsewhere, p-my prcatice)
e01comp:
    YouTube: Vladimir Vysokomornyi/Школа программирования
    Command User -> Comp
e02data:
    YouTube: Eugene Suleimanov
    Command Developer -> Database
e03tvli:
    [source lost]
    Command Switch -> Light & TV
e04gara:
    [source lost]
    Command Remote Control -> Light & Garage
e05pain:
    [source lost]
    Command Painter UI -> Holst

e06hdev:
    Book: Сьерра К. Паттерны проектирования
    Command Remote Control -> Many devices in house (+MACRO:many commands on one button)

e07wiki:
    ru.wikipedia.org
    Command Switch -> Light

e08lwik:
    ru.wikipedia.org
    Command Switch -> Light (Lyambda)

e09file:
    Book: Pankaj Kumar – Java Design Patterns. A Programmer’s Approach (2014-132)
    Command File -> OS operations

e10
    Book: Rohit Joshi - Java Design Patterns (2015-183)
    ThreadPool -> Email,File,Log,Sms

h01: my invented homework: Издательство печатной литературы
 in process..............