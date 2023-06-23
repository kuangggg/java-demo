#include "Main.h"
JNIEXPORT jint JNICALL Java_Main_max(JNIEnv *, jclass, jint, jint) {
	return a > b ? a : b;
}
