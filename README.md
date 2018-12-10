# J-merge

J-merge는 JSON(JavaScript Object Notation)을 병합하는데 사용할 수 있는 Java 라이브러리입니다.

# 다운로드

Gradle:

```groovy
dependencies {
	implementation 'com.github.ovso:j-merge:1.0.0'
}
```

Maven:<dependency>

```xml
<dependency>
	<groupId>com.github.ovso</groupId>
	<artifactId>j-merge</artifactId>
	<version>1.0.0</version>
</dependency>
```

# 전제조건

현재로서는, 구글의 [Gson](https://github.com/google/gson)을 사용해야 합니다.

# 사용법

배열 형태의 JsonObject를 병합하여 JsonObject로 반환합니다.

```java
JsonObject json1 = new JonObject();
JsonObject json2 = new JonObject();

Jmerge jmerge = new Jmerge();

JsonObject object = jmerge.merge(json1, json2, ...);
```

리스트 형태의 JsonObject를 병합하여 JsonObject로 반환합니다.

```
List<JsonObject> jsons = new ArrayList<>();
json.add(JsonObject)
...

Jmerge jmerge = new Jmerge();
JsonObject object = jmerge.merge(jsons);
```

# 예제

```json
// json1
{
    "a":1,
    "b":2,
    "c":[ 1, 2, 3]
}
// json2
{
    "c":[ 1, 2],
    "d":1,
    "e":"2"
}

// 병합 결과(json1, json2)
{
    "a":1,
    "b":2,
    "c":[1, 2, 3, 1, 2],
    "d":1,
    "e":"2"
}

```

배열이 아닐 때, 키가 동일하면 나중에 병합된 키와 값으로 교체됩니다

```json
// json1
{
    "a":1,
    "b":2
}
// json2
{
    "b":3,
    "c":4
}

// 병합 결과(json1, json2)
{
    "a":1,
    "b":3,
    "c":4
}
```
