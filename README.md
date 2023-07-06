# TabActionDemo
Demo project to show actions on loading tabs.

This project was built in response to a question posted on the [JavaFX](https://www.reddit.com/r/JavaFX/comments/14s0m0p/need_help_in_executor_service_and_javafx_task/) subreddit.

The OP was having difficulties managing the Task results coming in as different Tabs were selected.  Some demo code was included in the question and has been reproduced in the "original" package. 

This project has a "master" screen layout which simply has a TabPane which is populated by some number of Tabs.

Each Tab is implemented as a Model-View-Controller-Interactor (MVCI) structure.  There is a ViewBuilder to create the View and the Interactor simulates the loading of the data for the Tab.  Each Controller extends the abstract TabController and really only initializes the Model, ViewBuilder and Interactor in its constructor.  The Interactors implement an interface called TabInteractor which simply defines two Void methods to load the data off the FXAT, and then to update the Model on the FXAT.

The abstract TabController has a concrete method called fetchTabData() which instantiates a Task to call TabInteractor.loadData() on a background thread, and the to call TabInteractor.loadModel() on the FXAT.

With this structure each Tab MVCI is a sealed unit exposing only the Controller's constructor, the getView() and the fetchTabData() methods to the outside world.  The main Controller calls these, and then bundles the results up into some Maps to pass to the main ViewBuider.  That main ViewBuilder only receives vanilla objects: Strings, Regions and Runnables to work with in the Maps, reducing the coupling between components.

## This Design is Not Good 

Not the MVCI structure, but the idea of loading Tabs when they are selected.  

It isn't clear why the OP wants to do this, but it's highly likely that it's dealing with some perceived performance issue.  However, the OP immediately ran into issues when Tabs were clicked quickly in succession - a problem which was entirely predictable.  

The MVCI framework approach isolates each Tab, and therefore deals with the OP's stated problem, but it isn't clear why the Tabs couldn't all be loaded simultaneously as soon as the screen is initialized.  If the underlying data is extremely volatile, then it will become stale if the user sits on one Tab for a long period of time anyways - so that isn't a good reason to use this approach. 

Compounding the issue is the OP's approach was to use a SingleThreadExecutorPool to run the Tasks.  This guarantees that only one Tab can load at a time, and several clicks on Tabs will create a backlog very quickly if the Tasks take a measurable amount of time to run.  Once again, it's not clear why this approach was taken but it's probably reasonable to assume that this is some sort of performance optimizing mechanism that avoids having too many background Threads running at the same time. 
