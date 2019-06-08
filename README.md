# MuseMinimals
This repository contains all the minimal apks with source codes used in the study of Muse Framework


## TemplateApp
Is the barebone app that acts as template for the newer minimal apps

RunOnUIThread
=============
Origin:
Discovered using the reachability app for protect-baby-monitor. 

Summary:
FlowDroid does not recognize threads started using the runOnUIThread(Runnable) method.

ButtonOnClickToDialogOnClick
============================
Origin:
Discovered using the reachability app for LocationShare.

Summary:
FlowDroid does not recognize the onClick(DialogInterface, int) callback of DialogInterface.OnClickListener when a dialog is created with that listener within a Button onClick=“method_name” callback defined in xml. It will recognize this callback if the Button’s xml-defined callback is called normally, such as within an Activity’s onCreate(Bundle) method.

DialogFragmentShow
==================
Origin: 
Discovered using the reachability app for ActivityLauncher (leaks 56 and 57).

Summary:
FlowDroid does not recognize the flow from DialogFragment.show(FragmentManager, String) to that DialogFragment’s onCreateDialog() method.

NavigationView
==============
Origin:
Discovered using the reachability app for ActivityLauncher (leaks 65, 66, 67).

Summary:
FlowDroid does not recognize the onNavigationItemSelected(MenuItem) callback of classes implementing NavigationView.OnNavigationItemSelectedListener.

ExecutorService
===============
Origin:
Discovered using the reachability app for ActivityLauncher (leaks 154, 155, 182).

Summary:
FlowDroid does not recognize the path to Runnable.run() when a Runnable is passed into ExecutorService.submit(Runnable).

PhoneStateListener
==================
Origin:
Discovered using the reachability app for ActivityLauncher (leak 231).

Summary:
FlowDroid does not recognize the onDataConnectionStateChanged(int) callback for classes extending android.telephony.PhoneStateListener.

BroadcastReceiver
=================
Origin:
Adwait Nadkarni’s intuition.

Summary:
FlowDroid does not recognize the onReceive() callback of BroadcastReceivers implemented programmatically and registered within another programmatically defined and registered BroadcastReceiver’s onReceive() callback. Additionally, some other callbacks (i.e. the DialogInterface.OnClickListener from ButtonOnClickToDialogOnClick) are not recognized within a BroadcastReceiver’s onReceive() callback, while others (i.e. new Thread(new Runnable() {run() {/*leak*/}}).start();) are. 


