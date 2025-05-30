/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.wren.base.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static io.wren.base.Utils.requireNonNullEmpty;

public class View
{
    private final String name;
    private final String statement;

    public static View view(String name, String statement)
    {
        return new View(name, statement, null);
    }

    @JsonCreator
    public View(
            @JsonProperty("name") String name,
            @JsonProperty("statement") String statement,
            @JsonProperty("properties") Map<String, String> properties)
    {
        this.name = requireNonNullEmpty(name, "name is null or empty");
        this.statement = requireNonNullEmpty(statement, "statement is null or empty");
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public String getStatement()
    {
        return statement;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        View view = (View) o;
        return Objects.equals(name, view.name) &&
                Objects.equals(statement, view.statement);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                name,
                statement);
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("name", name)
                .add("statement", statement)
                .toString();
    }
}
