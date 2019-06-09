# MuseMinimals
This helper repository contains all the minimal apks with source codes used in the study of Muse Framework.

## TemplateApp
Is the barebone app that acts as template for the newer minimal apps.

## RunOnUIThread

### Origin
Discovered using the reachability app for protect-baby-monitor. 

### Summary
FlowDroid does not recognize threads started using the `runOnUIThread(Runnable)` method.

## ButtonOnClickToDialogOnClick

### Origin
Discovered using the reachability app for LocationShare.

### Summary
FlowDroid does not recognize the `onClick(DialogInterface, int)` callback of `DialogInterface.OnClickListener` when a dialog is created with that listener within a Button `onClick"method_name"` callback defined in xml. It will recognize this callback if the Button’s xml-defined callback is called normally, such as within an Activity’s `onCreate(Bundle)` method.

## DialogFragmentShow

### Origin 
Discovered using the reachability app for `ActivityLauncher` (leaks 56 and 57).

### Summary
FlowDroid does not recognize the flow from `DialogFragment.show(FragmentManager, String)` to that DialogFragment’s `onCreateDialog()` method.

## NavigationView

### Origin
Discovered using the reachability app for `ActivityLauncher` (leaks 65, 66, 67).

### Summary
FlowDroid does not recognize the `onNavigationItemSelected(MenuItem)` callback of classes implementing `NavigationView.OnNavigationItemSelectedListener`.

## ExecutorService

### Origin
Discovered using the reachability app for ActivityLauncher (leaks 154, 155, 182).

### Summary
FlowDroid does not recognize the path to `Runnable.run()` when a Runnable is passed into `ExecutorService.submit(Runnable)`.

## PhoneStateListener

### Origin
Discovered using the reachability app for `ActivityLauncher` (leak 231).

### Summary
FlowDroid does not recognize the `onDataConnectionStateChanged(int)` callback for classes extending `android.telephony.PhoneStateListener`.

## BroadcastReceiver

### Origin
Adwait Nadkarni’s intuition.

### Summary
FlowDroid does not recognize the `onReceive()` callback of BroadcastReceivers implemented programmatically and registered within another programmatically defined and registered BroadcastReceiver’s onReceive() callback. Additionally, some other callbacks (i.e. the `DialogInterface.OnClickListener` from `ButtonOnClickToDialogOnClick)` are not recognized within a `BroadcastReceiver’s onReceive()` callback, while others (i.e. `new Thread(new Runnable() {run() {/*leak*/}}).start();`) are. 

## LocationListenerTaint*

### Summary
A `LocationListener` allows Android applications to react to changes in the user’s location. In this example, a LocationListener is registered to save a data source when the location provider’s status changes, such as when the user loses or regains cellular service, and leak the data when the user moves and changes location.

## NSDManager*

### Summary
An `NsdManager.DiscoveryListener` can be used to discover network services. In this example, a data leak source is placed within the `onDiscoveryStarted()` callback of the DiscoveryListener, which is called when the listener begins searching for services. Sinks are placed within the callbacks of a ResolveListener for either successful service resolution or failure, instantiated within the `onServiceFound()` callback of the DiscoveryListener.

## ListViewCallBackSequential*

### Summary
A ListView is instantiated with an `onItemClickListener()` whose `onItemClick()` callback will be called when an element in the ListView is selected. The callback first captures the element selected, casting it to the appropriate "Example" class, and then calls two functions within the class. The first function, "foo()" saves the source of a data leak to a private variable, and the second, "`bar()`", leaks it.

## ThreadTaint* 

### Summary
A data leak source is saved to a variable within some method, and a Runnable containing a sink for the variable within its run() method is submitted to a Thread. It is important to note that the Thread is first saved to a variable before `Thread.start()` is called, as opposed to "`new Thread(…).start()`".

## FragmentApp*

### Summary
A Fragment from the Android Support Library contains a simple data leak within its `onCreateView()` lifecycle callback. This callback is called when the Fragment is instantiated using the FragmentManager transaction mechanism.

###SQLiteOpenHelper*

### Summary
A class extending the `SQLiteOpenHelper` abstract class contains a simple data leak within its `onCreate()` callback. This callback is called when the referenced database is created for the first time.