import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { getCacheSize, clearCache } from '@damoness/react-native-http-cache';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  React.useEffect(() => {
    getCacheSize().then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>CacheSize: {result}</Text>
      <Button
        title="清除"
        onPress={() => {
          clearCache();
          setResult(0);
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
