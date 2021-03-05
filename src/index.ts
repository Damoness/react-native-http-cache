import { NativeModules } from 'react-native';
const native = NativeModules.DMNHttpCache;

export const clearHttpCache = native.clearHttpCache;
export const clearImageCache = native.clearImageCache;

export async function getCacheSize(): Promise<number> {
  const arr = await Promise.all([getHttpCacheSize(), getImageCacheSize()]);

  console.log(arr.join(','));
  return arr.reduce((a, b) => a + b, 0);
}

export async function getHttpCacheSize(): Promise<number> {
  const size: number = await native.getHttpCacheSize();
  return size;
}

export async function getImageCacheSize(): Promise<number> {
  const size: number = await native.getImageCacheSize();
  return size;
}

export function sizeNumToReadStr(size: number): string {
  let str = '0 K';

  if (size >= 1024 * 1024 * 1024) {
    str = `${(size / 1024.0 / 1024.0 / 1024.0).toFixed(2)} G`;
  } else if (size >= 1024 * 1024) {
    str = `${(size / 1024.0 / 1024.0).toFixed(2)} M`;
  } else if (size >= 1024) {
    str = `${(size / 1024.0).toFixed(2)} K`;
  }

  return str;
}

export async function clearCache() {
  await Promise.all([clearHttpCache(), clearImageCache()]);
}
