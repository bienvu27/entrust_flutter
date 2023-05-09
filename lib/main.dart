import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const TestEntrust(),
    );
  }
}

class TestEntrust extends StatefulWidget {
  const TestEntrust({Key? key}) : super(key: key);

  @override
  State<TestEntrust> createState() => _TestEntrustState();
}

class _TestEntrustState extends State<TestEntrust> {
  static const platform = MethodChannel('entrust.sdk.dev/flutter');

  Future<void> testEntrust() async {
    try {
      final package =
      await platform.invokeMethod("test");
      print(package);
    } on PlatformException catch (e) {
      print("Failed to get battery level: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: ElevatedButton(onPressed: (){
          testEntrust();
        }, child: const Text('Submit')),
      ),

    );
  }
}
