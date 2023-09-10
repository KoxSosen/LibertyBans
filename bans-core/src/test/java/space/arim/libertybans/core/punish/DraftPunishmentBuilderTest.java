/*
 * LibertyBans
 * Copyright © 2021 Anand Beh
 *
 * LibertyBans is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * LibertyBans is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */

package space.arim.libertybans.core.punish;

import org.junit.jupiter.api.Test;
import space.arim.libertybans.api.PlayerVictim;
import space.arim.libertybans.api.PunishmentType;
import space.arim.libertybans.api.punish.DraftPunishmentBuilder;
import space.arim.libertybans.core.scope.InternalScopeManager;
import space.arim.libertybans.core.scope.ScopeImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DraftPunishmentBuilderTest {

    @Test
    public void draftPunishmentBuilderBuild() {
        Enactor enactor = mock(Enactor.class);
        InternalScopeManager internalScopeManager = mock(InternalScopeManager.class);
        DraftPunishmentBuilder draftPunishmentBuilder = mock(DraftPunishmentBuilder.class);

        when(enactor.scopeManager()).thenReturn(internalScopeManager);
        when(enactor.draftBuilder()).thenReturn(draftPunishmentBuilder);

        var builder = new DraftPunishmentBuilderImpl(enactor)
                .type(PunishmentType.BAN)
                .scope(ScopeImpl.GLOBAL)
                .victim(PlayerVictim.of(UUID.randomUUID()))
                .reason("Test")
                .build();

        assertEquals(builder.toBuilder().build(), builder);

    }

}
