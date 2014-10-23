﻿using System;
using System.Collections;
using System.Diagnostics;
using System.Linq;
using System.Reflection;
using Windows.UI.Xaml;

namespace PocketCampus.Common
{
    // FRAMEWORK BUG: Bindings to Dictionary<K,V> don't work.
    //    Workaround: This converts them to a custom class with which bindings work.
    public sealed class DictionaryFixer : ValueConverter<IDictionary, IEnumerable>
    {
        public override IEnumerable Convert( IDictionary value )
        {
            if ( value == null )
            {
                return Enumerable.Empty<KeyValuePair>();
            }
            return value.Cast<dynamic>().Select( d => new KeyValuePair( d.Key, d.Value ) ).ToArray();
        }

        public sealed class KeyValuePair
        {
            public object Key { get; private set; }
            public object Value { get; private set; }

            public KeyValuePair( object key, object value )
            {
                Key = key;
                Value = value;
            }
        }
    }

    public sealed class StringFormatConverter : ValueConverter<object, string, string>
    {
        public override string Convert( object value, string parameter )
        {
            return string.Format( "{0:" + parameter + "}", value );
        }
    }

    public sealed class MoneyFormatConverter : ValueConverter<object, string>
    {
        public override string Convert( object value )
        {
            if ( value == null )
            {
                return ""; // for nullable prices
            }

            return string.Format( "{0:0.00} CHF", value );
        }
    }

    public sealed class EnumToStringConverter : ValueConverter<Enum, string>
    {
        public override string Convert( Enum value )
        {
            string enumName = value.GetType().Name;
            string val = value.ToString();

            try
            {
                return LocalizationHelper.GetLoaderForCurrentAssembly( enumName ).GetString( val );
            }
            catch
            {
                // Happens when a binding in page A is updated after a navigation to page B.
                Debug.WriteLine( "EnumToStringConverter: " + enumName + "." + val + " not found." );
                return "";
            }
        }
    }

    public sealed class DefaultToVisibilityConverter : ValueConverter<object, Visibility>
    {
        public bool IsReversed { get; set; }

        public override Visibility Convert( object value )
        {
            return IsDefaultValue( value ) ^ IsReversed ? Visibility.Visible : Visibility.Collapsed;
        }

        private static bool IsDefaultValue( object value )
        {
            if ( value == null )
            {
                return true;
            }

            var str = value as string;
            if ( str != null && str.Trim().Length == 0 )
            {
                return true;
            }

            var collection = value as IEnumerable;
            if ( collection != null )
            {
                return !collection.GetEnumerator().MoveNext();
            }

            var type = value.GetType();
            if ( type.GetTypeInfo().IsValueType )
            {
                return object.Equals( value, Activator.CreateInstance( type ) );
            }

            // not null, not a value type
            return false;
        }
    }
}