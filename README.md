FnUI Example App
================

This is the example app to try out the current state of FnUI.

State Of Project
----------------

This project is currently a ALPHA version and non of the APIs are currently stable.

Therefore there are no release versions yet and the source release should be considered
as a showcase to acquire feedback.

Setup
-----

The following steps are describing how you can execute the fnui-example-app to checkout the FnUI.

1. Get Grails 2.4.4 to run in your shell (see instructions ).

2. Make a new dir for your test and go into it.

3. Checkout all the repositories to your test-dir:

```
git clone https://github.com/fnui/fnui-core.git
git clone https://github.com/fnui/fnui-model.git
git clone https://github.com/fnui/fnui-generator.git
git clone https://github.com/fnui/fnui-adminlte.git
git clone https://github.com/fnui/fnui-adminlte-security.git
git clone https://github.com/fnui/fnui-example-app.git
```

4. Generate the UI:

```
cd fnui-example-app
grails generate-fnui
```

5. Run the app:

```
grails run-app
```


