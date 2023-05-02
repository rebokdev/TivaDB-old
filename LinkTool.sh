for Platform in $(ls src | grep Main);
do
  PlatformPath="$(pwd)/src/$Platform/kotlin"
  # shellcheck disable=SC2045
  for KtFile in $(ls Common);
  do
    if [[ $PlatformPath != *"common"* ]] ; then
      KtFilePath="$(pwd)/Common/$KtFile"
      ln -sr $KtFilePath $PlatformPath > /dev/null 2>&1
    fi
  done
done